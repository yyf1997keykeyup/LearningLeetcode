package Tree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    /***
     * Leetcode #102: https://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrderTraversalRecursion(TreeNode root) {
        /*
         * Recursion Version of the level order traversal
         */
        if (root == null) return levels;
        traversal(root, 0);
        return levels;
    }
    private void traversal(TreeNode node, int level) {
        // init the current level
        if (levels.size() == level)
            levels.add(new LinkedList<>());

        levels.get(level).add(node.val);

        if (node.left != null)
            traversal(node.left, level + 1);
        if (node.right != null)
            traversal(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderTraversalIteration(TreeNode root) {
        /*
         * Iteration Version of the level order traversal
         */
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new LinkedList<>());
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}
