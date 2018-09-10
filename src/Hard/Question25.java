package Hard;

import util.ListNode;

public class Question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode prev = head;
        ListNode cur = prev.next;
        while(cur != null && k-1 > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            k--;
        }
        head.next = cur;
        return prev;
    }
}
