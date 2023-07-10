package Hard;

import utils.ListNode;

import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length);
        ListNode head = new ListNode(0);
        ListNode cur = head;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;

            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return head.next;
    }
}
