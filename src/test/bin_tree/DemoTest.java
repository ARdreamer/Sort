package test.bin_tree;


import sun.misc.Unsafe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DemoTest {

    public void insert(int key, int value) {
        Node root = new Node(value);
        root = insert(root, key, value);
    }

    public Node insert(Node node, int key, int value) {
        if (node == null) {
            Node.count++;
            return new Node(value);
        }
        if (key == node.key)
            node.value = value;
        else if (key < node.key)
            node.left = insert(node.left, key, value);
        else
            node.right = insert(node.right, key, value);
        return node;
    }

    public void digui_qian() {
        Node head = new Node(1);
        if (head == null)
            return;
        else {
            System.out.println(head.value);
            digui_qian();//zuo
            digui_qian();//you
        }
    }

    public void digui_zhong() {
        Node head = new Node(1);
        if (head == null)
            return;
        else {
            digui_qian();//zuo
            System.out.println(head.value);
            digui_qian();//you
        }
    }

    public void digui_hou() {
        Node head = new Node(1);
        if (head == null)
            return;
        else {
            digui_qian();//zuo
            digui_qian();//you
            System.out.println(head.value);
        }
    }

    public void qian() {
        Node head = new Node(1);
        if (head != null) {
            Stack<Node> stack = new Stack();
            stack.push(head);
            Node cur;
            while (!stack.empty()) {
                cur = stack.pop();
                System.out.println(cur.value);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }

    public void zhong() {
        Node head = new Node(1);
        Node cur = head;
        Stack<Node> stack = new Stack();
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node pop = stack.pop();
            System.out.println(pop.value);
            cur = pop.right;
        }
    }

    public void hou() {
        Node head = new Node(1);
        Stack<Node> stack1 = new Stack<>();//入栈然后让他们出栈
        Stack<Node> stack2 = new Stack<>();//后序遍历顺序为左 右 中 所以 入栈顺序为 中 右 左
        Node cur;
        stack1.push(head);
        while (!stack1.empty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.empty()) {
            cur = stack2.pop();
            System.out.println(cur.value);
        }
    }

    /**
     * 该节点的左右孩子皆为空，即该节点为叶子节点，那么这次遍历就是打印该点。
     * 如果上一次打印的节点为该节点的右孩子，说明该节点的子树处理完毕，这次遍历就是打印该点。
     * 如果上一次打印的节点为该节点的左孩子，且该节点的右孩子为空，说明该节点的子树处理完毕，这次遍历就是打印该点。
     * 否则说明子树没有被访问过，按照右孩子、左孩子的顺序入栈。
     */
    public void hou2() {
        Node head = new Node(1);
        Stack<Node> stack = new Stack();
        stack.push(head);
        Node last = null;
        Node top;
        while (!stack.empty()) {
            top = stack.pop();
            if ((top.left == null && top.right == null) //叶子结点
                    || (top.right == null && last == top.left)//上个访问为左孩子，且右孩子为空
                    || (last == top.right)) {
                System.out.println(top.value);
                last = top;
            } else {
                stack.push(top);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
    }

    public void cengcibianli() {
        Node head = new Node(1);
        Deque<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.removeFirst();
            System.out.println(cur.value);
            if (cur.left != null) {
                ((LinkedList<Node>) queue).add(cur.left);
            }
            if (cur.right != null) {
                ((LinkedList<Node>) queue).add(cur.right);
            }
        }
    }

    public void quanpailie() {
        char[] aaa = new char[]{'a', 'b', 'c', 'd'};
        permutation(aaa, 0, aaa.length - 1);
    }

    void permutation(char[] aaa, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) {
                System.out.print(aaa[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                char t = aaa[i];
                aaa[i] = aaa[k];
                aaa[k] = t;
                permutation(aaa, k + 1, m);
                t = aaa[i];
                aaa[i] = aaa[k];
                aaa[k] = t;
            }
        }
    }
}
