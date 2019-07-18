package SearchSpecialNumber;

import java.util.LinkedList;
import java.util.List;

public class Problem418 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i += 1) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val]  = - nums[val];
            }
        }
        for (int j = 0; j < nums.length; j += 1) {
            if (nums[j] > 0) {
                list.add(j + 1);
            }
        }
        return list;
    }
}
