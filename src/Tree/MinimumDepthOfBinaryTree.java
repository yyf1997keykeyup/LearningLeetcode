package Tree;

import Common.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        /*
         * 1. (leaf)      if left == 0 && right == 0, then return 0 + 0 + 1 == 1
         * 2. (one child) if left == 0 && right != 0, then return right + 1
         * 3. (one child) if left != 0 && right == 0, then return left + 1
         * 4. (two child) if left != 0 && right != 0, then return Math.min(left, right) + 1
         */
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}