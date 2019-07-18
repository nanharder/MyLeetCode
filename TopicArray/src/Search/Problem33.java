package Search;

public class Problem33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                if (target < nums[0]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                continue;
            }

            if (target > num) {
                low = mid + 1;
            } else if (target < num) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
