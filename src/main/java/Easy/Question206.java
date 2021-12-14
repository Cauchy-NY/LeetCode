package Easy;

import utils.ListNode;

public class Question206 {
    // 三指针调转小箭头方向
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head, cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 从第2个节点到第n个节点，依次逐节点插入到第1个节点之后
    // 1->2->3->4->5->null => 1->5->4->3->2->null
    // 连成环，再从原头处剪开
    // 1->5->4->3->2->null => 1->5->4->3->2->1 => 5->4->3->2->1->null
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head.next, record = head.next; // record是依次插入后的尾节点
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = tmp;
        }
        record.next = head;
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    // 递归实现
    public ListNode reverseList_3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1->2->3->4->null => 4->3->2->null, 1->2
        ListNode newHead = reverseList_3(head.next);
        // head.next = 2, 2.next = head, head.next = null
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
