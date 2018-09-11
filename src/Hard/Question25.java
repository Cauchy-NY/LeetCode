package Hard;

import util.ListNode;

public class Question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode find = head;
        while(count != k && find != null) {
            find = find.next;
            count++;
        }
        ListNode prev = head;
        if(count == k) {
            ListNode cur = prev.next;
            while(cur != null && count-1 > 0) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
                count--;
            }
            head.next = reverseKGroup(cur, k);
        }
        return prev;
    }
}
