import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = combinationHelper(candidates, target, candidates.length - 1);
        return res;
    }

    private List<List<Integer>> combinationHelper(int[] candidates, int target, int right) {
        List<List<Integer>> res = new ArrayList<>();
        if (right < 0) {
            return res;
        }
        if (target == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        res = combinationHelper(candidates, target, right - 1);
        if (target >= candidates[right]) {
            List<List<Integer>> cur = combinationHelper(candidates, target - candidates[right], right);
            for (List<Integer> sum : cur) {
                sum.add(candidates[right]);
                res.add(sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem39 p = new Problem39();
        int[] test = new int[]{2,3 ,6 ,7};
        p.combinationSum(test, 7);
    }
}
