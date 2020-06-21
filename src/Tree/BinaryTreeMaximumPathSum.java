package Tree;

import Common.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ret;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxPathSum = Math.max(helper(root.left), 0);
        int rightMaxPathSum = Math.max(helper(root.right), 0);
        int curPathSum = leftMaxPathSum + rightMaxPathSum + root.val;
        ret = Math.max(ret, curPathSum);
        return root.val + Math.max(leftMaxPathSum, rightMaxPathSum);
    }
}
