/**
 * removeElement
 */
public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int mark = -1;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != val) {
                mark += 1;
                nums[mark] = nums[i];
            }
        }
        return mark + 1;
    }
}
