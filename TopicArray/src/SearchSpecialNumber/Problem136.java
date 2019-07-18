package SearchSpecialNumber;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i += 1) {
            res = res ^ nums[i];
        }
        return res;
    }
}
