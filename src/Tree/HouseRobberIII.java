package Tree;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!memo.containsKey(root)) {
            int toRob = root.val
                    + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                    + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
            int NotToRob = rob(root.left) + rob(root.right);
            int res = Math.max(toRob, NotToRob);
            memo.put(root, res);
        }
        return memo.get(root);
    }
}
