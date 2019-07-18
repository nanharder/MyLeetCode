import java.util.ArrayList;
import java.util.List;

public class Problem530 {
    private int pre = -1;
    private int re = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        if (pre != -1) {
            re = Math.min(re, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return re;
    }


    /**
     *

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); i += 1) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val)
        inorder(root.right, list);

    }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
