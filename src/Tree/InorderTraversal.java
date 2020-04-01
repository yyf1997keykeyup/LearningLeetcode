package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    /***
     * Leetcode #94: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        /*
         * Recursion Version of in-order traversal
         */
        List<Integer> inorder = new LinkedList<>();
        traversal(root, inorder);
        return inorder;
    }
    private void traversal(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        traversal(node.left, inorder);
        inorder.add(node.val);
        traversal(node.right, inorder);
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        /*
         * Iteration Version of in-order traversal
         */
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
    }
}
