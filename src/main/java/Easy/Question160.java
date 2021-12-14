package Easy;

import utils.ListNode;

public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null)
//            return null;
//
//        Set<ListNode> set = new HashSet<>();
//        ListNode cur = headA;
//        while (cur != null) {
//            set.add(cur);
//            cur = cur.next;
//        }
//
//        cur = headB;
//        while (cur != null) {
//            if (set.contains(cur))
//                return cur;
//            cur = cur.next;
//        }
//        return null;
//    }
}
