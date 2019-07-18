package Sort;

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateBST(nums, 0, nums.length - 1);
    }

    private TreeNode generateBST(int[] nums, int left, int right) {
        int len = right - left + 1;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(nums[left]);
        } else {
            int half = (left + right) / 2;
            TreeNode root = new TreeNode(nums[half]);
            root.left = generateBST(nums, left, half - 1);
            root.right = generateBST(nums, half + 1, right);
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
