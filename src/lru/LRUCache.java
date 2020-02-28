package lru;

import java.util.HashMap;

public class LRUCache<k, v> {
    class Node {
        Node prev;
        Node next;
        k key;
        v value;

        public Node(k key) {
            this.key = key;
        }
    }

    private int currentSize;
    private int cacheSize;
    private Node head;
    private Node last;
    private HashMap<k, Node> map;

    public LRUCache(int size) {
        this.cacheSize = size;
        currentSize = 0;
        map = new HashMap<>();
    }

    /**
     * 获取缓存中对象,并把它放在最前面
     *
     * @param key 键
     * @return 当前key对应的对象
     */
    public v get(k key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return null;
        }
    }

    public void put(k key, v value) {
        Node node = map.get(key);
        if (node == null) {
            if (currentSize >= cacheSize) {
                map.remove(last.key);
                removeLast();
            } else {
                currentSize++;
            }
            node = new Node(key);
        }
        node.value = value;
        moveToHead(node);
        map.put(key, node);

    }

    public void remove(k key) {
        Node node = map.remove(key);
        if (node != null) {
//            map.remove(key);
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == last) {
                last = node.prev;
            }
            if (node == head) {
                head = node.next;
            }
        }
    }

    private void removeLast() {
        if (last != null) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                head = null;
            }
            last = last.prev;
        }
    }

    /**
     * 移动到链表头，表示这个节点是最新使用过的
     *
     * @param node 需要移动的节点
     */
    private void moveToHead(Node node) {
        if (node == head)
            return;
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == last) {
            last = node.prev;
        }
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        node.prev = null;
        if (last == null) {
            last = head;
        }
    }

    public void clear() {
        head = null;
        last = null;
        currentSize = 0;
    }
}
