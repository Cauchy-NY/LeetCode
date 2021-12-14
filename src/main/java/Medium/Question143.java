package Medium;

import utils.ListNode;

public class Question143 {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur1 = head;
        ListNode cur2 = reverse(slow.next);
        slow.next = null;

        while (cur1 != null && cur2 != null) {
            ListNode tmpCur1 = cur1;
            ListNode tmpCur2 = cur2;
            cur1 = cur1.next;
            cur2 = cur2.next;
            tmpCur1.next = tmpCur2;
            tmpCur2.next = cur1;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList(4);
        new Question143().reorderList(head);
        System.out.println(ListNode.toString(head));
    }
}
