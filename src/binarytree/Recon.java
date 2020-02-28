package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Recon {
    /**
     * 先序 序列化
     *
     * @param head
     * @return
     */
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        } else {
            String res = head.value + "!";
            res += serialByPre(head.left);
            res += serialByPre(head.right);
            return res;
        }
    }

    /**
     * 反序列化
     *
     * @param res
     * @return
     */
    public static Node reconByPreString(String res) {
        String[] str = res.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String str = queue.poll();
        if ("#".equals(str)) {
            return null;
        } else {
            Node head = new Node(Integer.parseInt(str));
            head.left = reconPreOrder(queue);
            head.right = reconPreOrder(queue);
            return head;
        }
    }
}
