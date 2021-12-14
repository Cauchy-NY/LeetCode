package Medium;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Question142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;  // 慢指针每次走一步
            fast = fast.next.next;  // 快指针每次走两步
            if (slow == fast)
                break;
        }
        if (fast.next == null || fast.next.next == null)
            return null;
        fast = head;  //重新定义快指针，并将其指向起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 使用 hash table
    public ListNode hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return head;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
