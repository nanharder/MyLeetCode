package Arraymove;

/**
 * removeDuplicates II, similar to the past question
 */
public class Problem80 {
    public int removeDuplicates(int[] nums) {
        int mark = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i] != nums[mark]) {
                mark += 1;
                nums[mark] = nums[i];
                count = 1;
            } else if (count < 2) {
                mark += 1;
                nums[mark] = nums[i];
                count += 1;
            }
        }
        return mark + 1;
    }
}
