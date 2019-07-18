package Search;

public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] start = findfirst(nums, target);
        if (start[0] == 0) {
            return new int[]{-1, -1};
        } else {
            return new int[]{start[1], findfirst(nums, target + 1)[1] - 1};
        }
    }

    private int[] findfirst(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{0, 0};
        }
        int upperbound = nums.length - 1;
        int lowerbound = 0;
        while (upperbound > lowerbound) {
            int divide = (upperbound - lowerbound) / 2 + lowerbound;
            if (nums[divide] < target) {
                lowerbound = divide + 1;
            } else {
                upperbound = divide;
            }
        }
        if (nums[lowerbound] == target) {
            return new int[]{1, lowerbound};
        } else if (nums[lowerbound] < target) {
            return new int[]{0, lowerbound + 1};
        } else {
            return new int[]{0, lowerbound};
        }
    }

    public static void main(String[] args) {
        Problem34 p = new Problem34();
        int[] test = new int[]{1};
        p.findfirst(test, 2);
    }
}
