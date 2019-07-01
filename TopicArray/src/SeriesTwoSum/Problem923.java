package SeriesTwoSum;


import java.util.*;

/**
 * threeSumMultiV1 important!!!
 */
public class Problem923 {
    private final static int MODULE = 1000000007;
    public static int threeSumMultiV1(int[] A, int target) {
        if (A.length < 3 || A == null) {
            return 0;
        }
        Arrays.sort(A);
        long result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        HashSet<HashMap<Integer, Integer>> source = new HashSet<>();
        for (int i = 0; i < A.length; i += 1) {
            if(count.containsKey(A[i])) {
                count.put(A[i], count.get(A[i]) + 1);
                continue;
            } else {
                count.put(A[i], 1);
            }
            int left = i + 1;
            int right = A.length - 1;
            int remain = target - A[i];

            while(left < right) {
                if (A[left] + A[right] == remain) {
                    deposit(Arrays.asList(A[i], A[left], A[right]), source);
                    left += 1;
                    right -= 1;

                    while(left < right && (A[left] == A[left - 1])) {
                        left += 1;
                    }
                    while(left < right && (A[right] == A[right + 1])) {
                        right -= 1;
                    }
                } else if (A[left] + A[right] < remain) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        for (HashMap<Integer, Integer> map : source) {
            long cal = 1;
            for (int i : map.keySet()) {
                cal = cal * calcuRes(i, map.get(i), count);
                cal %= MODULE;
            }
            result += cal;
        }
        return (int) (result % MODULE);
    }

    private static void deposit(List<Integer> nums, HashSet<HashMap<Integer, Integer>> source) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i : nums) {
            if (result.containsKey(i)) {
                int count = result.get(i);
                result.put(i, count + 1);
            } else {
                result.put(i, 1);
            }
        }
        source.add(result);
    }

    private static long calcuRes(int i, int num, HashMap<Integer, Integer> count) {
        long base = 1;
        long c = count.get(i);
        long k = 1;
        while (k <= num) {
            base = base * c / k;
            c -= 1;
            k += 1;
        }
        return base % 1000000007;
    }

    public static int threeSumMultiV2(int[] A, int target) {
        long res = 0;
        long[] count = new long[101];
        for (int i: A) {
            count[i] += 1;
        }

        if (target % 3 == 0) {
            int t = target / 3;
            if (count[t] >= 3) {
                res += count[t] * (count[t] - 1) * (count[t] - 2) / 6;
            }
        }
        for (int i = 0; i <= 100; i += 1) {
            if (i > target) {
                break;
            }
            if (count[i] == 0) {
                continue;
            }
            if ((target - i) % 2 == 0) {
                int half = (target - i) / 2;
                if (half <= 100 && half != i && count[half] >= 2) {
                    res += count[i] * count[half] * (count[half] - 1) / 2;
                }
            }
            int left = move(i + 1, 1, count);
            int right = move(100, -1, count);

            while (right > left) {
                int cur = i + left + right;
                if (cur == target) {
                    res += count[i] * count[left] * count[right];
                    right = move(right - 1, -1, count);
                    left = move(left + 1, 1, count);
                } else if (cur > target) {
                    right = move(right - 1, -1, count);
                } else {
                    left = move(left + 1, 1, count);
                }
            }
        }
        return (int) res % MODULE;
    }

    private static int move(int n, int dir, long[] nums) {
        while (true) {
            if (n > 100) {
                return n;
            }
            if (n < 0) {
                return 0;
            }
            if (nums[n] > 0) {
                break;
            }
            n += dir;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] test = new int[3000];
        System.out.println(threeSumMultiV2(test, 0));
    }
}
