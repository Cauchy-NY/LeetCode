package Hard;

import utils.ListNode;

import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode head = new ListNode(0);
        ListNode point = head;

        for(ListNode node: lists)
            if(node != null)
                queue.add(node);

        while(!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;

            if(point.next != null)
                queue.add(point.next);
        }
        return head.next;
    }
}
