package Medium;

import utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Question138 {

    private Map<RandomListNode, RandomListNode> visitedMap = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        if (visitedMap.containsKey(head)) {
            return visitedMap.get(head);
        }

        RandomListNode newNode = new RandomListNode(head.label);

        visitedMap.put(head, newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);

        return newNode;
    }
}
