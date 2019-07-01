package SeriesTwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fourSum, decompose to threeSum
 */
public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 1) {
            if(i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            threeSum(nums, res, target - nums[i], i);
        }
        return res;
    }

    private void threeSum(int[] nums, List<List<Integer>> results, int target, int start) {
        for (int i = start + 1; i < nums.length; i += 1) {
            if(i > start + 1 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int aim = target - nums[i];

            while(left < right) {
                if (nums[left] + nums[right] == aim) {
                    results.add(Arrays.asList(nums[start], nums[i], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                    while(left < right && (nums[left] == nums[left - 1])) {
                        left += 1;
                    }
                    while(left < right && (nums[right] == nums[right + 1])) {
                        right -= 1;
                    }
                } else if (nums[left] + nums[right] < aim) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
    }
}
