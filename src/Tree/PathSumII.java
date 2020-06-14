package Tree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root, sum, cur, res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>res){
        if (root == null){
            return;
        }
        cur.add(root.val);
        if (root.val - sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(cur));
        }else{
            pathSum(root.left, sum - root.val, cur, res);
            pathSum(root.right, sum - root.val, cur, res);
        }
        cur.remove(cur.size()-1);
    }
}
