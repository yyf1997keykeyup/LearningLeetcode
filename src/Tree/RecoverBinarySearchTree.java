package Tree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
    /*
     * From: https://leetcode.com/articles/recover-binary-search-tree/
     * Todo: write all of the other solutions
     */
    public void recoverTree(TreeNode root) {
        /*
         * Sort an Almost Sorted Array Where Two Elements Are Swapped
         * Time Complexity:  O(N)
         * Space Complexity: O(N)
         */
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap
                if (x == -1) x = nums.get(i);
                    // second swap
                else break;
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode r, int count, int x, int y) {
        if (r != null) {
            if (r.val == x || r.val == y) {
                r.val = r.val == x ? y : x;
                if (--count == 0) return;
            }
            recover(r.left, count, x, y);
            recover(r.right, count, x, y);
        }
    }
}
