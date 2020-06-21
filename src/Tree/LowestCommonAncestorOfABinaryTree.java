package Tree;

import Common.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * Recursion Version
         * From: https://leetcode.com/articles/lowest-common-ancestor-of-a-binary-tree/
         */
        this.recur(root, p, q);
        return this.ans;
    }
    private boolean recur(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = this.recur(currentNode.left, p, q) ? 1 : 0;
        int right = this.recur(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        return (mid + left + right > 0);
    }

}
