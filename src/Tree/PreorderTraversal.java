package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        /*
         * Recursion Version of pre-order traversal
         */
        List<Integer> preorder = new LinkedList<>();
        traversal(root, preorder);
        return preorder;
    }
    private void traversal(TreeNode node, List<Integer> preorder) {
        if (node == null) return;
        preorder.add(node.val);
        traversal(node.left, preorder);
        traversal(node.right, preorder);
    }

    public List<Integer> preorderTraversalIteration(TreeNode root) {
        /*
         * Iteration Version of pre-order traversal
         */
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
