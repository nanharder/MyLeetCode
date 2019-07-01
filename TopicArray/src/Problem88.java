/**
 * mergesort
 */
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (copy[i] <= nums2[j]) {
                nums1[i + j] = copy[i];
                i += 1;
            } else {
                nums1[i + j] = nums2[j];
                j += 1;
            }
        }
        if (i == m) {
            System.arraycopy(nums2, j, nums1, i + j, n - j);
        } else {
            System.arraycopy(copy, i, nums1, i + j, m - i);
        }

    }
}
