package SearchSpecialNumber;

public class Problem137 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i += 1) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
