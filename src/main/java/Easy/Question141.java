package Easy;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Question141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;  // 慢指针每次走一步
            fast = fast.next.next;  // 快指针每次走两步
            if (slow == fast)
                return true;
        }
        return false;
    }

    // 使用 hash table
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head))
                return true;
            else
                nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}
