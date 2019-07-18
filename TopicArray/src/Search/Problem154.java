package Search;

public class Problem154 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (nums[low] == nums[high] && low < high) {
            low += 1;
        }
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        int num = nums[nums.length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= num) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
