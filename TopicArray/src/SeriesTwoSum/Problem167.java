package SeriesTwoSum;

/**
 * TwoSum II
 * two mark at the first and last index, move based on the sum
 */
public class Problem167 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[] {l + 1, r + 1};
            } else if (nums[l] + nums[r] > target) {
                r -= 1;
            } else {
                l += 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
