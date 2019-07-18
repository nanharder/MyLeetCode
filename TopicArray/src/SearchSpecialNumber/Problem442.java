package SearchSpecialNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 1) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val]  = - nums[val];
            } else {
                list.add(val + 1);
            }
        }
        return list;
    }
}
