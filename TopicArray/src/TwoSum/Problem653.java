package TwoSum;

import java.util.*;

/**
 *TwoSum of binaryTree
 */
public class Problem653 {
    /**
     * traversal method like the problem1
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }

    /**
     *decompose the problem into problem167 sortedlists
     */

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) + list.get(r) == k) {
                return true;
            } else if (list.get(l) + list.get(r) > k) {
                r -= 1;
            } else {
                l += 1;
            }
        }
        return false;
    }
}
