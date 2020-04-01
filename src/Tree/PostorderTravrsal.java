package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTravrsal {
    /***
     * Leetcode #145: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        /*
         * Recursion Version of post-order traversal
         */
        List<Integer> postorder = new LinkedList<>();
        traversal(root, postorder);
        return postorder;
    }
    private void traversal(TreeNode node, List<Integer> postorder) {
        if (node == null) return;
        traversal(node.left, postorder);
        traversal(node.right, postorder);
        postorder.add(node.val);
    }
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        /*
         * Iteration Version of post-order traversal
         * Since we store the result in a linked list, we can add every value to the head.
         */
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
        }
        return output;
    }
}
