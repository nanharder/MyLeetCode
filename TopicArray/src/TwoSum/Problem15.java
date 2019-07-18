package TwoSum;

import java.util.*;

public class Problem15 {
    /**
     * my method, useful but slow
     */
    public List<List<Integer>> threeSumV1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        while (numbers.size() > 2) {
            int k = numbers.remove(0);
            ArrayList<Integer> cur = new ArrayList<>(numbers);
            while (!cur.isEmpty()) {
                int base = cur.remove(0);
                int target = 0 - k - base;
                if (cur.contains(target)) {
                    results.add(Arrays.asList(k, base, target));
                    cur.removeIf(n -> n == target);
                }
            }
            numbers.removeIf(n -> n == k);
        }
        return results;
    }
    public List<List<Integer>> threeSumV2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length < 3 || nums == null) {
            return new ArrayList<>(res);
        }

        for (int i = 0; i < nums.length; i += 1) {
            int target = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j += 1) {
                int remain = target - nums[j];
                if (set.contains(remain)) {
                    List<Integer> result = new ArrayList<>(Arrays.asList(remain, nums[j], nums[i]));
                    Collections.sort(result);
                    res.add(result);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * first sort the array, it is fast
     */
    public List<List<Integer>> threeSumV3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 1) {
            if(i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];

            while(left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                    while(left < right && (nums[left] == nums[left - 1])) {
                        left += 1;
                    }
                    while(left < right && (nums[right] == nums[right + 1])) {
                        right -= 1;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return res;
    }
}
