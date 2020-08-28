package HashMap;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> new2old = new HashMap<>();
        Map<Node, Node> old2new = new HashMap<>();
        Node newHead = new Node(head.val);
        new2old.put(newHead, head);
        old2new.put(head, newHead);
        Node point = head;
        Node newPoint = newHead;
        while (point.next != null) {
            point = point.next;
            Node node = new Node(point.val);
            newPoint.next = node;
            newPoint = newPoint.next;
            new2old.put(node, point);
            old2new.put(point, node);
        }
        newPoint = newHead;
        while (newPoint != null) {
            newPoint.random = old2new.get(new2old.get(newPoint).random);
            newPoint = newPoint.next;
        }
        return newHead;
    }
}
