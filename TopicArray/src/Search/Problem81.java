package Search;

public class Problem81 {
    public boolean search(int[] nums, int target) {
        int base = 0;
        int high = nums.length - 1;
        while(base < high && nums[base] == nums[high]) {
            base += 1;
        }
        int low = base;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num;
            if ((nums[mid] < nums[base]) == (target < nums[base])) {
                num = nums[mid];
            } else {
                if (target < nums[base]) {
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
                return true;
            }
        }
        return false;
    }
}
