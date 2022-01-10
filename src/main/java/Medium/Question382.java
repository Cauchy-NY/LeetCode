package Medium;

import utils.ListNode;

import java.util.Random;

public class Question382 {

    // 蓄水池抽样算法(k=1时)
    // 遇到1，概率为1，保留第一个数。
    // 遇到2，概率为1/2，这个时候，1和2各1/2的概率被保留
    // 遇到3，3被保留的概率为1/3，(之前剩下的数假设1被保留)，2/3的概率 1 被保留，(此时1被保留的总概率为 2/3 * 1/2 = 1/3)
    // 遇到4，4被保留的概率为1/4，(之前剩下的数假设1被保留)，3/4的概率 1 被保留，(此时1被保留的总概率为 3/4 * 2/3 * 1/2 = 1/4)

    ListNode head;
    Random random;

    public Question382(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int ans = 0, count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            int r = random.nextInt(count) + 1;
            if (r == count) {
                ans = cur.val;
            }
            cur = cur.next;
        }
        return ans;
    }
}
