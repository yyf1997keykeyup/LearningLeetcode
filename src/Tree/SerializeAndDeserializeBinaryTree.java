package Tree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /*
     * My BFS Iteration Solution, Memory Limit Exceed by one case...
     *      1
     *     / \
     *    2   3
     *       /
     *      4
     *
     *  as "[1,2,3,null,null,4,null]"
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> serializedString = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean empty = false;
        while (!empty) {
            int levelSize = queue.size();
            empty = true;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    queue.add(null);
                    queue.add(null);
                    serializedString.add(null);
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                    if (node.left != null || node.right != null) {
                        empty = false;
                    }
                    serializedString.add(node.val);
                }
            }
        }
        int len = serializedString.size();
        return serializedString.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.substring(1, data.length() - 1).split(",");
        TreeNode[] nodeArr = new TreeNode[nodeValues.length];
        nodeArr[0] = new TreeNode(Integer.parseInt(nodeValues[0]));
        for (int i = 1; i < nodeValues.length; i++) {
            if (!nodeValues[i].trim().equals("null")) {
                nodeArr[i] = new TreeNode(Integer.parseInt(nodeValues[i].trim()));
                int parentIdx = getParentIdx(i);
                if (isLeft(i)) {
                    nodeArr[parentIdx].left = nodeArr[i];
                } else {
                    nodeArr[parentIdx].right = nodeArr[i];
                }
            }
        }
        return nodeArr[0];
    }

    private int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private boolean isLeft(int childIdx) {
        return (childIdx - 1) % 2 == 0;
    }

    public String serializeIteration(TreeNode root) {
        /*
         * BFS Iteration Version
         * From: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue
         */
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString();
    }

    public TreeNode deserializeIteration(String data) {
        if (data.equals("")) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
