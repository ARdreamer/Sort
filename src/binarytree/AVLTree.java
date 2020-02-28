package binarytree;

public class AVLTree {

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    //是否为AVL
    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
}
