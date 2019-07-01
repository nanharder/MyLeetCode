/**
 * removeDuplicates
 */
public class Problem26 {
    public int removeDuplicates(int[] nums) {
        int mark = 0;
        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i] != nums[mark]) {
                mark += 1;
                nums[mark] = nums[i];
            }
        }
        return mark + 1;
    }
}
