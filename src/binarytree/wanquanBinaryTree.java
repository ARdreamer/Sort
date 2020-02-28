package binarytree;

public class wanquanBinaryTree {

    /**
     * 求节点个数
     */
    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node  当前结点
     * @param level 当前节点在第几层
     * @param h     树的总深度
     * @return 以node为头的树总共有多少个节点
     */
    private static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        //node的右子树的左边界到了那一层
        if (mostLeftLevel(node.right, level + 1) == h) {
            //返回左子树的个数加上右子树的个数
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //右子树的个数加上左子树个数
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    private static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
