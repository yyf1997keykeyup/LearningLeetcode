package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    /***
     * Leetcode #100: https://leetcode.com/problems/same-tree/
     */
    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        /*
         * Recursion Version
         */
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }
    public boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        /*
         * Iteration Version
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }
        return true;
    }
}
