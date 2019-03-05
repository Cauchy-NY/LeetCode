package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (capacity == map.size())
            remove(tail.prev);
        insert(new Node(key, value));
    }

    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }

    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}
