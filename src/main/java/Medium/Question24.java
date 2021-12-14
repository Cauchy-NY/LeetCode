package Medium;

import utils.ListNode;

public class Question24 {
    public ListNode swapPairs(ListNode head) {
//        ListNode point = head;
//        while(point != null && point.next != null) {
//            // swap
//            ListNode tmp = point.next;
//            point.next = point.next.next;
//            tmp.next = head;
//            //point++
//            point = point.next;
//        }
//        return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
