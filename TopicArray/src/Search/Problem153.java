package Search;

public class Problem153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] > nums[low]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
