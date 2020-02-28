package lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePer<k,v> {
    class LRUNode {
        k key;
        v value;
        LRUNode next;
        LRUNode pre;

        public LRUNode(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<k, LRUNode> map = new HashMap<>();
    LRUNode head;
    LRUNode tail;
    // 缓存最大容量，我们假设最大容量大于 1，
    // 当然，小于等于1的话需要多加一些判断另行处理
    int capacity;

    public LRUCachePer(int capacity) {
        this.capacity = capacity;
    }

    public void put(k key, v value) {
        if (head == null) {
            head = new LRUNode(key, value);
            tail = head;
            map.put(key, head);
            return;
        }
        LRUNode node = map.get(key);
        if (node != null) {
            // 更新值
            node.value = value;
            // 把他从链表删除并且插入到头结点
            removeAndInsert(node);
        } else {
            LRUNode tmp = new LRUNode(key, value);
            // 如果会溢出
            if (map.size() >= capacity) {
                // 先把它从哈希表中删除
                map.remove(tail);
                // 删除尾部节点
                tail = tail.pre;
                tail.next = null;
            }
            map.put(key, tmp);
            // 插入
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }
    }

    public v get(k key) {
        LRUNode node = map.get(key);
        if (node != null) {
            // 把这个节点删除并插入到头结点
            removeAndInsert(node);
            return node.value;
        }
        return null;
    }

    private void removeAndInsert(LRUNode node) {
        // 特殊情况先判断，例如该节点是头结点或是尾部节点
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 插入到头结点
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }
}
