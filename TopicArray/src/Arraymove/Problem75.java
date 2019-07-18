package Arraymove;

import java.util.Collections;

public class Problem75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] == 0) {
            left += 1;
        }
        while (right >= 0 && nums[right] == 2) {
            right -= 1;
        }
        int index = left;
        while (index <= right) {
            if (nums[index] == 2) {
                swap(nums, index, right);
                right -= 1;
            } else if (nums[index] == 0) {
                swap(nums, index, left);
                left += 1;
                if (index < left) {
                    index = left;
                }
            } else {
                index += 1;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Problem75 p = new Problem75();
        int[] test = new int[]{2,0,2,1,1,0};
        p.sortColors(test);
    }
}
