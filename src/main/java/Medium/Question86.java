package Medium;

import util.ListNode;

public class Question86 {
    public ListNode partition(ListNode head, int x) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        ListNode p1 = n1;
        ListNode p2 = n2;
        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
            }
            else {
                p1.next = head;
                p1 = p1.next;
            }
            head = head.next;
        }
        p1.next = n2.next;
        p2.next = null;
        return n1.next;
    }
}
