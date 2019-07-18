package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 1) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addFirst(nums[0]);
            res.add(list);
            return res;
        }
        for (int i = 0; i < nums.length; i += 1) {
            List<List<Integer>> cur = permute(copyArray(nums, i));
            for (List<Integer> list : cur) {
                list.add(nums[i]);
            }
            res.addAll(cur);
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
