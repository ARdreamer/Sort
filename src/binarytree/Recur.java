package binarytree;

import java.util.Stack;

public class Recur {
    public static void preOrderRecur(Node head) {
        if (head == null)
            return;
        System.out.println(head.value + ' ');
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null)
            return;
        preOrderRecur(head.left);
        System.out.println(head.value + ' ');
        preOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head) {
        if (head == null)
            return;
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value + ' ');
    }

    public static void preOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.println(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    public static void postOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node cur = head;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value + " ");
        }
    }

    /**
     * 找后继节点 中序
     * 有右子树，它的后继结点是右子树的最左面的节点
     * 没有右子树，它的后继结点是它所在的左子树的打印的最后一个节点
     * <p>
     * ||
     * 前驱就是左子树最右的节点
     * 没有左子树就 往上找，当前结点是父节点的右孩子就行
     */
    public static Node getSuccessNode(Node node) {
        if (node == null)
            return node;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            //为空就是本树最后(最右)一个节点，压根没有后继
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
