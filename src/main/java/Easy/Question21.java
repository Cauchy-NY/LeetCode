package Easy;

import utils.ListNode;

public class Question21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(l1 != null && l2 != null) {
            int tmp = 0;
            if(l1.val < l2.val) {
                tmp = l1.val;
                l1 = l1.next;
            }
            else {
                tmp = l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(tmp);
            point.next = node;
            point = point.next;
        }
        if(l1 == null)
            point.next = l2;
        else
            point.next = l1;
        return head.next;
    }
}
