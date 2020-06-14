package Tree;

import Common.TreeNode;

public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }
    public void preOrder(TreeNode root, int curSum) {
        if (root != null) {
            curSum = curSum * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += curSum;
            }
            preOrder(root.left, curSum);
            preOrder(root.right, curSum) ;
        }
    }
}
