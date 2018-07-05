package 数据结构与算法.树;

/**
 * @Description 二叉树
 * @Author J
 * @Date 2018/7/5 11:46
 **/
public class BinaryTree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    /**
     * 先序遍历该二叉树
     *
     * @return 节点个数
     */
    public void preOrderTraverse(Node<T> root) {
        if (root != null) {
            this.visit(root);
            preOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
        }
    }

    /**
     * 中序遍历该二叉树
     *
     * @return 节点个数
     */
    public void inOrderTraverse(Node<T> root) {
        if (root != null) {
            inOrderTraverse(root.leftChild);
            this.visit(root);
            preOrderTraverse(root.rightChild);
        }
    }

    /**
     * 后序遍历该二叉树
     *
     * @return 节点个数
     */
    public void postOrderTraverse(Node<T> root) {
        if (root != null) {
            postOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
            this.visit(root);
        }
    }

    /**
     * 遍历时对节点的操作
     *
     * @param node 当前节点
     */
    private void visit(Node<T> node) {
        System.out.println(node.nodeData);
    }

    class Node<T> {
        T nodeData;

        Node<T> leftChild;

        Node<T> rightChild;
    }
}
