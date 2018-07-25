package 数据结构与算法.树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description AVL树
 * @Author J
 * @Date 2018/7/24 14:50
 **/
public class AVLTree<T extends Comparable<? super T>> {

    AVLTreeNode<T> root;

    public void initTree(T[] ts) {
        for (T item : ts) {
            this.put(item);
        }
    }

    public void put(T t) {
        AVLTreeNode<T> node = new AVLTreeNode<>(t);
        if (root == null) {
            root = node;
        } else {
            Deque<AVLTreeNode<T>> stack = new LinkedList<>();
            AVLTreeNode<T> current = root;
            AVLTreeNode<T> parent;
            while (current != null) {
                parent = current;
                stack.push(parent);
                int flag = t.compareTo(current.nodeData);
                if (flag <= 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                    }
                }
            }

            while (!stack.isEmpty()) {
                current = stack.pop();
                int balanceFactor = this.getHeight(current.left) - this.getHeight(current.right);
                //右旋
                if (balanceFactor > 1) {
                    AVLTreeNode<T> currentLeft = current.left;
                    //先左旋
                    if (t.compareTo(currentLeft.nodeData) > 0) {
                        this.leftRotate(currentLeft);
                    }
                    this.rightRotate(current);
                } else if (balanceFactor < -1) {
                    AVLTreeNode<T> currentRight = current.right;
                    //先左旋
                    if (t.compareTo(currentRight.nodeData) <= 0) {
                        this.rightRotate(currentRight);
                    }
                    this.leftRotate(current);
                }

                current.height = Math.max(this.getHeight(current.left), this.getHeight(current.right)) + 1;
            }
        }
    }


    protected int getHeight1(AVLTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int i = getHeight(root.left);
        int j = getHeight(root.right);
        return Math.max(i, j) + 1;
    }


    protected int getHeight(AVLTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    /**
     * 左旋
     *
     * @param root
     */
    @SuppressWarnings("unchecked")
    public void leftRotate(AVLTreeNode<T> root) {
        AVLTreeNode<T> rootRight = root.right;
        if (rootRight == null) {
            return;
        }

        AVLTreeNode<T> temp = new AVLTreeNode<>();
        //拷贝一份root
        this.recover(temp, root);
        //右子树设为原roo右子树的左子树
        temp.right = rootRight.left;

        //把原root覆盖
        this.recover(root, rootRight);

        //新的左子树为拷贝的temp
        root.left = temp;

        //计算旋转发生变化的两个点的高度
        temp.height = Math.max(this.getHeight(temp.left), this.getHeight(temp.right)) + 1;
        root.height = Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
    }

    /**
     * 右旋
     *
     * @param root
     */
    @SuppressWarnings("unchecked")
    public void rightRotate(AVLTreeNode<T> root) {
        AVLTreeNode<T> rootLeft = root.left;
        if (rootLeft == null) {
            return;
        }
        AVLTreeNode<T> temp = new AVLTreeNode<>();
        //拷贝一份root
        this.recover(temp, root);
        //右子树设为原roo右子树的左子树
        temp.left = rootLeft.right;

        //把原root覆盖
        this.recover(root, rootLeft);

        //新的左子树为拷贝的temp
        root.right = temp;

        //计算旋转发生变化的两个点的高度
        temp.height = Math.max(this.getHeight(temp.left), this.getHeight(temp.right)) + 1;
        root.height = Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
    }


    /**
     * 覆盖原来的节点
     *
     * @param oldNode
     * @param newNode
     */
    protected void recover(AVLTreeNode<T> oldNode, AVLTreeNode<T> newNode) {
        oldNode.left = newNode.left;
        oldNode.right = newNode.right;
        oldNode.nodeData = newNode.nodeData;
    }


    static class AVLTreeNode<T> {

        T nodeData;

        AVLTreeNode<T> left;

        AVLTreeNode<T> right;

        /**
         * 高度
         */
        protected int height;

        public AVLTreeNode() {
            super();
        }

        public AVLTreeNode(T data) {
            this.nodeData = data;
            this.height = 1;
        }

        @Override
        public String toString() {
            return "AVLTreeNode{" +
                    "nodeData=" + nodeData +
                    ", left=" + (left == null ? null : left.nodeData) +
                    ", right=" + (right == null ? null : right.nodeData) +
                    ", height=" + height +
                    '}';
        }
    }

    /**
     * 中序遍历该二叉树
     *
     * @return 节点个数
     */
    public void inOrderTraverse(AVLTreeNode<T> root) {
        if (root != null) {
            inOrderTraverse(root.left);
            this.visit(root);
            inOrderTraverse(root.right);
        }
    }

    /**
     * 遍历时对节点的操作
     *
     * @param avlTreeNode 当前节点
     */
    protected void visit(AVLTreeNode<T> avlTreeNode) {
        System.out.println(avlTreeNode);
    }


    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Integer a[] = {1, 3, 2, 4, 5, 6, 7};
        avlTree.initTree(a);


        avlTree.inOrderTraverse(avlTree.root);
        System.out.println("-------------------------------------");
        System.out.println("root: " + avlTree.root);
        System.out.println("高度: " + avlTree.getHeight1(avlTree.root));
    }
}
