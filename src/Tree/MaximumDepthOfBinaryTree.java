package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepthRecursion(TreeNode root) {
        /*
         * Recursion Version (one line)
         */
        return root == null ? 0 : Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right)) + 1;
    }
    public int maxDepthBFSIteration(TreeNode root) {
        /*
         * Iteration Version (BFS)
         */
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
}
