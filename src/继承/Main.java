package 继承;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> list = new ArrayList<>();

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        String val;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String pre = ss.split("\\,")[0];
        String in = ss.split("\\,")[1];
        String[] pres = new String[pre.length()];
        for (int i = 0; i < pre.length(); i++) {
            pres[i] = String.valueOf(pre.charAt(i));
        }
        String[] ins = new String[in.length()];
        for (int i = 0; i < in.length(); i++) {
            ins[i] = String.valueOf(in.charAt(i));
        }
        TreeNode root = reConstructBinaryTree(pres, ins);
        order(root);
        for (String s : list) {
            System.out.print(s);
        }
    }


    public static void order(TreeNode root) {
        if (root == null)
            return;
        else {
            order(root.left);
            order(root.right);
            list.add(root.val);
        }
    }

    public static TreeNode reConstructBinaryTree(String[] pre, String[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(String[] pre, int startPre, int endPre, String[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i].equals(pre[startPre])) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + (i - startIn), in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, (i - startIn) + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
