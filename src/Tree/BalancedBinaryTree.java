package Tree;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
    /*
     * Bottom to top (from https://leetcode.com/problems/balanced-binary-tree/solution/)
     */
    class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    class Solution {
        private TreeInfo isBalancedTreeHelper(TreeNode root) {
            if (root == null) {
                return new TreeInfo(-1, true);
            }
            TreeInfo left = isBalancedTreeHelper(root.left);
            if (!left.balanced) {
                return new TreeInfo(-1, false);
            }
            TreeInfo right = isBalancedTreeHelper(root.right);
            if (!right.balanced) {
                return new TreeInfo(-1, false);
            }
            if (Math.abs(left.height - right.height) < 2) {
                return new TreeInfo(Math.max(left.height, right.height) + 1, true);
            }
            return new TreeInfo(-1, false);
        }

        public boolean isBalanced(TreeNode root) {
            return isBalancedTreeHelper(root).balanced;
        }
    };
}
