package StackQueue;

import Common.ListNode;

import java.util.PriorityQueue;

/**
 * From: https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists (Hard)
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });
        ListNode dummyHead = new ListNode(0);
        ListNode point = dummyHead;
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            point.next = new ListNode(node.val);
            point = point.next;
            node = node.next;
            if (node != null) {
                queue.offer(node);
            }
        }
        return dummyHead.next;
    }
}
