package Permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 1) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addFirst(nums[0]);
            res.add(list);
            return res;
        }
        HashSet<Integer> done = new HashSet<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (done.contains(nums[i])) {
                continue;
            }
            List<List<Integer>> cur = permuteUnique(copyArray(nums, i));
            for (List<Integer> list : cur) {
                list.add(nums[i]);
            }
            res.addAll(cur);
            done.add(nums[i]);
        }
        return res;
    }

    private int[] copyArray(int[] nums, int index) {
        int[] res = new int[nums.length - 1];
        for (int i = 0; i < res.length; i += 1) {
            if (i >= index) {
                res[i] = nums[i + 1];
            } else {
                res[i] = nums[i];
            }
        }
        return res;
    }
}
