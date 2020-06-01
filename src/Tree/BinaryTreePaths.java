package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    public List<String> binaryTreePathsRecursion(TreeNode root) {
        /*
         * Recursion Version
         */
        List<String> paths = new LinkedList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null)
                paths.add(path);
            else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePathsIteration(TreeNode root) {
        /*
         * Iteration Version
         */
        List<String> paths = new LinkedList<>();
        if (root == null)
            return paths;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.add(root);
        pathStack.add(Integer.toString(root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if (node.left == null && node.right == null)
                paths.add(path);
            if (node.left != null) {
                nodeStack.add(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
}
