package TwoSum;

import java.util.HashMap;

public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int N = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                int sumAB = numA + numB;
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int numC : C) {
            for (int numD : D) {
                int sumCD = numC + numD;
                res += map.getOrDefault(-sumCD, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem454 test = new Problem454();
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1, 1};
        int[] C = new int[]{-1, 1};
        int[] D = new int[]{1, -1};
        System.out.println(test.fourSumCount(A, B, C, D));
    }
}
