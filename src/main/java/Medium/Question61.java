package Medium;

import utils.ListNode;

public class Question61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        ListNode tail = head, newHead = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (k % len == 0)
            return head;
        else
            k = k % len;
        for (int i = 0; i < len-k-1; i++) {
            newHead = newHead.next;
        }
        ListNode newTail = newHead;
        newHead = newHead.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}
