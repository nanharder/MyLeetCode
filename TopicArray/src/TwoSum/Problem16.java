package TwoSum;

import java.util.Arrays;

/**
 * threeSumClosest, similar to the problem15
 */
public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3 || nums == null) {
            throw new IllegalArgumentException();
        }
        int result = nums[0] + nums[1] + nums[2];
        int curMax = Math.abs(result - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 1) {
            if(i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < curMax) {
                    result = sum;
                    curMax = Math.abs(sum - target);
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return result;
    }

}
