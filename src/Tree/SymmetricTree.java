package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    /***
     * Leetcode #101: https://leetcode.com/problems/symmetric-tree/
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        /*
         * Recursion Version
         */
        return root == null || isSymmetricRecursionHelper(root.left, root.right);
    }

    private boolean isSymmetricRecursionHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return isSymmetricRecursionHelper(left.left, right.right) && isSymmetricRecursionHelper(left.right, right.left);
    }

    public boolean isSymmetricIteration(TreeNode root) {
        /*
         * Iteration Version (with Queue. You can also use stack if you want : P )
         */
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
