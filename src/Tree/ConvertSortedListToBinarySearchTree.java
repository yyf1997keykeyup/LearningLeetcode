package Tree;

import Common.ListNode;
import Common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBSTRecursion(ListNode head) {
        /*
         * Recursion Version
         * Time Complexity:  O(NlogN)
         * Space Complexity: O(logN)
         */
        if (head == null) {
            return null;
        }
        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) {
            return node;
        }
        node.left = this.sortedListToBSTRecursion(head);
        node.right = this.sortedListToBSTRecursion(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPoint = null;
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        while (fastPoint != null && fastPoint.next != null) {
            prevPoint = slowPoint;
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        if (prevPoint != null) {
            prevPoint.next = null;
        }
        return slowPoint;
    }

    public TreeNode sortedListToBSTRecursionII(int[] nums) {
        /*
         * Recursion Version II. Making it just like <108. Convert Sorted Array to Binary Search Tree>
         * Time Complexity:  O(N)
         * Space Complexity: O(N)
         */
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

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        /*
         * Inorder Simulation
         * From: https://leetcode.com/articles/convert-sorted-list-to-binary-search-tree/
         * Time Complexity:  O(N)
         * Space Complexity: O(logN)
         */
        int size = this.findSize(head);
        this.head = head;
        return convertListToBST(0, size - 1);
    }

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = this.convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }
}
