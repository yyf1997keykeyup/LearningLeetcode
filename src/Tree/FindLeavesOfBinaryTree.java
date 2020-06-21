package Tree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    private List<List<Integer>> leaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        leaves = new ArrayList<>();
        dfs(root);
        return leaves;
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int level = 1 + Math.max(dfs(node.left), dfs(node.right));
        if (leaves.size() <= level) {
            leaves.add(new ArrayList<>());
        }
        leaves.get(level).add(node.val);
        return level;
    }
}
