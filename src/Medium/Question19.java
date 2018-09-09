package Medium;

import util.ListNode;

public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(!isLarger(head, n))
            return head.next;
        ListNode p = head;
        while(p != null) {
            if(isBehindTarget(p, n))
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }

    private boolean isBehindTarget(ListNode node, int n) {
        while(node != null) {
            node = node.next;
            n--;
        }
        if(n == -1)
            return true;
        else
            return false;
    }

    private boolean isLarger(ListNode head, int n) {
        while(head != null && n > 0) {
            head = head.next;
            n--;
        }
        if(head == null)
            return false;
        else
            return true;
    }
}
