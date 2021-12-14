package Easy;

import utils.ListNode;

public class Question83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode point = head;
        ListNode pre = fakeHead;
        while (point != null) {
            while (point.next != null && point.val == point.next.val) {
                point = point.next;
            }
            pre.next = point;
            pre = pre.next;
            point = point.next;
        }
        return fakeHead.next;
    }

    public static void main(String...args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        new Question83().deleteDuplicates(head);
    }
}
