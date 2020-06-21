package Tree;

import Common.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBSTRecursion(TreeNode root) {
        /*
         * Recursion Version
         */
        return helper(root, null, null);
    }
    private boolean helper(TreeNode node, Integer minimum, Integer maximum) {
        if (node == null) {
            return true;
        }
        if (minimum != null && node.val <= minimum) {
            return false;
        }
        if (maximum != null && node.val >= maximum) {
            return false;
        }
        if (!helper(node.left, minimum, node.val)) {
            return false;
        }
        if (!helper(node.right, node.val, maximum)) {
            return false;
        }
        return true;
    }
    public boolean isValidBSTInorder(TreeNode root) {
        /*
         * Inorder stack Iteration Version
         * credit to: https://leetcode.com/articles/validate-binary-search-tree/
         */
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        // double inorder = Double.MIN_VALUE;   // [0] not pass
        // int inorder = Integer.MIN_VALUE;     // [-2147483648] not pass
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
