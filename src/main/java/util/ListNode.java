package util;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode getLinkedList(int len) {
        if (len < 1)
            return null;

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < len; i++) {
            ListNode node = new ListNode(i+1);
            cur.next = node;
            cur = node;
        }

        return head;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null)
                sb.append("->");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
