package Medium;

import utils.ListNode;

public class Question82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode point = head;
        ListNode pre = fakeHead;
        while (point != null) {
            while (point.next != null && point.val == point.next.val) {
                point = point.next;
            }
            if (pre.next == point)
                pre = pre.next;
            else
                pre.next = point.next;
            point = point.next;
        }
        return fakeHead.next;
    }
}
