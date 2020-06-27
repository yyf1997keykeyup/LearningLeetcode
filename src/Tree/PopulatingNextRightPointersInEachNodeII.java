package Tree;

import Common.Node;

public class PopulatingNextRightPointersInEachNodeII {
    /*
     * From: https://leetcode.com/articles/populating-next-right-pointers-in-each-node-ii/
     */
    Node prev, leftmost;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        this.leftmost = root;
        Node curr;
        while (this.leftmost != null) {
            this.prev = null;
            curr = this.leftmost;
            this.leftmost = null;
            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

    public void processChild(Node childNode) {
        if (childNode == null) {
            return;
        }
        if (this.prev == null) {
            this.leftmost = childNode;
        } else {
            this.prev.next = childNode;
        }
        this.prev = childNode;
    }
}
