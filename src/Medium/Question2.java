package Medium;

import util.ListNode;

public class Question2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode point = result;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int tmpSum = carry;

            if(l1 != null) {
                tmpSum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                tmpSum += l2.val;
                l2 = l2.next;
            }

            point.next = new ListNode(tmpSum % 10);
            point = point.next;
            carry = tmpSum / 10;
        }

        if(carry == 1) {
            point.next = new ListNode(1);
        }

        return result.next;
    }
}
