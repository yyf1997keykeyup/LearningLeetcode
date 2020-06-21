package Tree;

import Common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recur(nums, start, mid - 1);
        node.right = recur(nums, mid + 1, end);
        return node;
    }
}
