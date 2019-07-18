package SubArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> count = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (count.containsKey(nums[i])) {
                count.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                count.put(nums[i], list);
            }
        }
        int degree = 0;
        int res = Integer.MAX_VALUE;
        for (int num : count.keySet()) {
            ArrayList<Integer> target = count.get(num);
            if (target.size() > degree) {
                degree = target.size();
                res = target.get(target.size() - 1) - target.get(0) + 1;
            } else if (target.size() == degree) {
                res = Math.min(target.get(target.size() - 1) - target.get(0) + 1, res);
            }
        }
        return res;
    }
}
