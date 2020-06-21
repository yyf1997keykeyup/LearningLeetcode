package Tree;

import Common.TreeNode;

public class CountUnivalueSubtrees {
    private int counter = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return counter;
    }
    public Boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            counter++;
            return true;
        }
        boolean isUnival = true;
        if (root.left != null) {
            isUnival =  dfs(root.left) && root.left.val == root.val;
        }
        if (root.right != null) {
            isUnival = dfs(root.right) && isUnival && root.right.val == root.val;
        }
        if (isUnival) {
            counter++;
            return true;
        }
        return false;
    }
}
