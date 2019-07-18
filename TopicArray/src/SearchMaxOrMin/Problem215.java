package SearchMaxOrMin;

import java.util.Arrays;

public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Problem215 p = new Problem215();
        int[] test = new int[]{3,2,3,1,2,4,5,5,6};
        p.findKthLargest(test, 4);
    }
}
