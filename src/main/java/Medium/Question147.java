package Medium;

import utils.ListNode;

public class Question147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode newTail = new ListNode(Integer.MAX_VALUE);
        newHead.next = newTail;

        while (head != null) {
            ListNode cur = head;
            head = head.next;

            ListNode beforeTmpCur = newHead;
            ListNode tmpCur = newHead;
            while (tmpCur != newTail) {
                tmpCur = tmpCur.next;
                if (cur.val <= tmpCur.val) {
                    beforeTmpCur.next = cur;
                    cur.next = tmpCur;
                    break;
                }
                beforeTmpCur = beforeTmpCur.next;
            }
        }

        ListNode cur = newHead;
        while (cur.next != newTail)
            cur = cur.next;
        cur.next = null;

        return newHead.next;
    }
}
