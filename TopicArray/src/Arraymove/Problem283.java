package Arraymove;

public class Problem283 {
    public void moveZeroes(int[] nums) {
        int shift = 0;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != 0) {
                nums[i - shift] = nums[i];
            } else {
                shift += 1;
            }
        }
        for (int j = 0; j < shift; j += 1) {
            nums[nums.length - j - 1] = 0;
        }
    }
}
