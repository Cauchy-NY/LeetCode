package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFUCache {

    private final int capacity;
    private int curTime;

    private final Map<Integer, Node> map = new HashMap<>();
    private final TreeSet<Node> seqSet = new TreeSet<>(Node::compareTo);

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curTime = 0;
    }

    public int get(int key) {
        if (capacity == 0 || !map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        seqSet.remove(node);
        node.cnt += 1;
        node.time = ++curTime;
        seqSet.add(node);
        map.put(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            seqSet.remove(node);
            node.value = value;
            node.cnt += 1;
            node.time = ++curTime;
            seqSet.add(node);
            map.put(key, node);
        } else {
            if (seqSet.size() == capacity) {
                map.remove(seqSet.first().key);
                seqSet.remove(seqSet.first());
            }
            Node node = new Node(1, ++curTime, key, value);
            map.put(key, node);
            seqSet.add(node);
        }
    }

    static class Node implements Comparable<Node> {
        int cnt, time, key, value;

        Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Node) {
                Node rhs = (Node) other;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }
            return false;
        }

        @Override
        public int compareTo(Node other) {
            return cnt == other.cnt ? time - other.time : cnt - other.cnt;
        }

        @Override
        public int hashCode() {
            return cnt * 1000000007 + time;
        }
    }
}