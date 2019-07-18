package SortII;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = 0, n2 = 0;
        boolean evenNum = (nums1.length + nums2.length) % 2 == 0;
        int end = (nums1.length + nums2.length - 1) / 2;
        while (end > 0) {
            if (getNum(nums1, n1) <= getNum(nums2, n2)) {
                n1 += 1;
            } else {
                n2 += 1;
            }
            end -= 1;
        }
        if (evenNum) {
            double firstNum = 0;
            if (getNum(nums1, n1) <= getNum(nums2, n2)) {
                firstNum = getNum(nums1, n1);
                n1 += 1;
            } else {
                firstNum = getNum(nums2, n2);
                n2 += 1;
            }
            return (firstNum + (double) Math.min(getNum(nums1, n1), getNum(nums2, n2))) / 2;
        } else {
            return (double) Math.min(getNum(nums1, n1), getNum(nums2, n2));
        }
    }

    private int getNum(int[] nums, int index) {
        if (index < nums.length) {
            return nums[index];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Problem4 p = new Problem4();
        p.findMedianSortedArrays(nums1, nums2);
    }
}
