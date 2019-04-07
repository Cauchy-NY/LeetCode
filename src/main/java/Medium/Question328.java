package Medium;

import util.ListNode;

public class Question328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode evenHead = head.next;
        ListNode oddCur = head, evenCur = head.next;

        while (evenCur != null && oddCur.next.next != null) {
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }

        oddCur.next = evenHead;

        return head;
    }
}
