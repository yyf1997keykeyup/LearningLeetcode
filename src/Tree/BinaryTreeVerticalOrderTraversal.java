package Tree;

import Common.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Map<Integer, ArrayList<Integer>> columnId2List = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int columnId = 0;
        queue.offer(new Pair<>(root, columnId));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> nodeColumnPair = queue.poll();
            TreeNode node = nodeColumnPair.getKey();
            columnId = nodeColumnPair.getValue();
            if (node != null) {
                if (!columnId2List.containsKey(columnId)) {
                    columnId2List.put(columnId, new ArrayList<>());
                }
                columnId2List.get(columnId).add(node.val);
                queue.add(new Pair<>(node.left, columnId - 1));
                queue.add(new Pair<>(node.right, columnId + 1));
            }
        }
        // columnId2List -> ret
        List<Integer> sortedKeys = new ArrayList<>(columnId2List.keySet());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k : sortedKeys) {
            if (min > k) {
                min = k;
            }
            if (max < k) {
                max = k;
            }
        }
        for(int i=min; i<=max; i++) {
            ret.add(columnId2List.get(i));
        }
        return ret;
    }
}
