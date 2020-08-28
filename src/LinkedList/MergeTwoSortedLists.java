package LinkedList;

import Common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }
        return dummyHead.next;
    }
}
