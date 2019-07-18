package Search;

/**
 * searchInsert binarysearch
 */
public class Problem35 {
    public int searchInsertV1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsertV2(int[] nums, int target) {
        int upperbound = nums.length - 1;
        int lowerbound = 0;
        while (upperbound > lowerbound) {
            int divide = (upperbound + lowerbound) / 2;
            if (nums[divide] == target) {
                return divide;
            } else if (nums[divide] > target) {
                upperbound = divide;
            } else {
                lowerbound = divide + 1;
            }
        }
        if (nums[lowerbound] >= target) {
            return lowerbound;
        } else {
            return lowerbound + 1;
        }
    }
}
