package 笔试五八;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class First {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node createBinaryTreeByArray(Integer[] array, int index) {
        Node tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

        public int levelOrder(Node root) {
            if (root == null)
                return 0;
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            double avl = 0;
            int ceng = 0;
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int qqq = size;
                count++;
                int sum = 0;
                while (size-- > 0) {
                    Node node = queue.poll();
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                    sum += node.val;
                }
                double a = sum / qqq;
                if (a > avl) {
                    avl = a;
                    ceng = count;
                }
            }
            return ceng;
        }


    public Node createTree(int[] array) {
        List<Node> nodeList = new LinkedList<Node>();

        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        for (int parentIndex = 0; parentIndex <= array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //防止是非完全二叉树
            if ((parentIndex * 2 + 2) < array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            String value = scanner.next();
            if (value.equals("null")) {
                array[i] = null;
            } else {
                array[i] = Integer.valueOf(value);
            }

        }
        First solution = new First();
        Node root = solution.createBinaryTreeByArray(array, 0);
        int level = solution.levelOrder(root);
        System.out.println(level);

    }
}