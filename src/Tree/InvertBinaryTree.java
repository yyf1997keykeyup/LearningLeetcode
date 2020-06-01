package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTreeRecursion(TreeNode root) {
        /*
         * Recursion Version
         */
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);
        return root;
    }
    public TreeNode invertTreeIteration(TreeNode root) {
        /*
         * Iteration Version
         */
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}
