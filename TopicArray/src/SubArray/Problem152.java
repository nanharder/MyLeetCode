package SubArray;

public class Problem152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            int lastmax = max;
            int lastmin = min;
            max = Math.max(Math.max(lastmax * nums[i], lastmin * nums[i]), nums[i]);
            min = Math.min(Math.min(lastmax * nums[i], lastmin * nums[i]), nums[i]);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}
