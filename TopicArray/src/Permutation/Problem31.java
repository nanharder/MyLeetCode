package Permutation;

public class Problem31 {
    public void nextPermutation(int[] nums) {
        int cur = nums.length - 1;
        while (cur > 0 && nums[cur] <= nums[cur - 1]) {
            cur -= 1;
        }
        if (cur == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int target = nums[cur - 1];
            for (int i = nums.length - 1; i >= cur; i -= 1) {
                if (nums[i] > target) {
                    swap(nums, i, cur - 1);
                    reverse(nums, cur, nums.length - 1);
                    break;
                }
            }
        }
    }

    private void swap (int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }
}
