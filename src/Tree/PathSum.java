package Tree;

import Common.TreeNode;

import java.util.LinkedList;

public class PathSum {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        /*
         * Recursion Version
         */
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSumRecursion(root.left, sum - root.val) ||
                hasPathSumRecursion(root.right, sum - root.val);
    }

    public boolean hasPathSumIteration(TreeNode root, int sum) {
        /*
         * Iteration Version
         */
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            int currSum = sumStack.pollLast();
            if (node.right == null && node.left == null && currSum == 0)
                return true;

            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }
        }
        return false;
    }
}
