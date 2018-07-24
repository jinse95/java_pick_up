package 数据结构与算法.树;

/**
 * @Description 二叉树
 * @Author J
 * @Date 2018/7/5 11:46
 **/
public class BinaryTree<T> {

    protected BinaryTreeNode<T> root;

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    /**
     * 先序遍历该二叉树
     *
     * @return 节点个数
     */
    public void preOrderTraverse(BinaryTreeNode<T> root) {
        if (root != null) {
            this.visit(root);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * 中序遍历该二叉树
     *
     * @return 节点个数
     */
    public void inOrderTraverse(BinaryTreeNode<T> root) {
        if (root != null) {
            inOrderTraverse(root.left);
            this.visit(root);
            inOrderTraverse(root.right);
        }
    }

    /**
     * 后序遍历该二叉树
     *
     * @return 节点个数
     */
    public void postOrderTraverse(BinaryTreeNode<T> root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            this.visit(root);
        }
    }


    /**
     * 遍历时对节点的操作
     *
     * @param binaryTreeNode 当前节点
     */
    protected void visit(BinaryTreeNode<T> binaryTreeNode) {
        System.out.println(binaryTreeNode);
    }

    public static class BinaryTreeNode<T> {

        BinaryTreeNode<T> parent;

        T nodeData;

        BinaryTreeNode<T> left;

        BinaryTreeNode<T> right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(T nodeData) {
            this.nodeData = nodeData;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "nodeData=" + nodeData +
                    ", parent=" + (parent == null ? null : parent.nodeData) +
                    ", left=" + (left == null ? null : left.nodeData) +
                    ", right=" + (right == null ? null : right.nodeData) +
                    '}';
        }
    }
}
