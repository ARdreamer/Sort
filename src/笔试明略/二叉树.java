package 笔试明略;

public class 二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode max = new TreeNode(Integer.MIN_VALUE);
    TreeNode min = new TreeNode(Integer.MAX_VALUE);

    public int getDis(TreeNode root) {
        findNode(root);
        TreeNode parent = findParent(root);
        int a = getLength(parent, max);
        int b = getLength(parent, min);
        return a + b;
    }

    public void findNode(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val > max.val) {
                max = root;
            } else if (root.val < min.val) {
                min = root;
            }
        }
        findNode(root.left);
        findNode(root.right);

    }

    private TreeNode findParent(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val == max.val || root.val == min.val) {
            return root;
        }
        TreeNode left = findParent(root.left);
        TreeNode right = findParent(root.right);
        return left == null ? right : (right == null ? left : root);
//        if (left == null) {
//            return right;
//        } else if (right == null) {
//            return left;
//        } else {
//            return root;
//        }
    }

    private int getLength(TreeNode parent, TreeNode node) {
        if (parent == null) {
            return -1;
        }
        if (parent.val == node.val) {
            return 0;
        }
        int dis = getLength(parent.left, node);
        if (dis == -1) {
            dis = getLength(parent.right, node);
        }
        if (dis != -1) {
            return dis + 1;
        }
        return -1;
    }
}
