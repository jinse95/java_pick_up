package 数据结构与算法.树;

/**
 * @Description 二叉排序树
 * @Author J
 * @Date 2018/7/5 11:46
 **/
public class BinarySortTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void initTree(T[] ts) {
        for (T item : ts) {
            this.put(item);
        }
    }

    public void put(T t) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>(t);
        if (root == null) {
            root = node;
        } else {
            BinaryTreeNode<T> currentNode = root;
            while (true) {
                if (t.compareTo(currentNode.nodeData) <= 0) {
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        node.parent = currentNode;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        node.parent = currentNode;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public BinaryTreeNode<T> search(T t) {
        return search(root, new BinaryTreeNode<>(t));
    }

    public BinaryTreeNode<T> search(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
        BinaryTreeNode<T> current = root;
        T data = node.nodeData;
        while (true) {
            if (current == null) {
                return null;
            }
            int flag = data.compareTo(current.nodeData);
            if (flag == 0) {
                return current;
            } else if (flag > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
    }

    public boolean delete(T t) {
        BinaryTreeNode<T> node = this.search(t);
        if (node == null) {
            return false;
        }
        BinaryTreeNode<T> left = node.left;
        BinaryTreeNode<T> right = node.right;
        BinaryTreeNode<T> temp;

        if (left == null && right == null) {
            temp = node.parent;
            //根节点
            if (temp == null) {
                node.nodeData = null;
                return true;
            }
            int flag = node.nodeData.compareTo(temp.nodeData);
            if (flag < 0) {
                temp.left = null;
            } else {
                temp.right = null;
            }
            return true;
        }

        if (left == null) {
            temp = node.right;
            node.left = temp.left;
            node.right = temp.right;
            node.nodeData = temp.nodeData;

        } else if (right == null) {
            temp = node.left;
            node.left = temp.left;
            node.right = temp.right;
            node.nodeData = temp.nodeData;
        } else {
            temp = node;
            //右子树的最左的节点
            temp = temp.right;
            if (temp.left == null) {
                temp.left = node.left;
                this.root = temp;
            } else {
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.nodeData = temp.nodeData;
                temp.parent.left = null;
            }
        }
        return true;
    }

    private void recover(BinaryTreeNode<T> oldNode, BinaryTreeNode<T> newNode) {
        if (newNode == null) {
            return;
        }
        oldNode.left = newNode.left;
        oldNode.right = newNode.right;
        oldNode.nodeData = newNode.nodeData;
    }

    public static void main(String[] args) {
        BinarySortTree<Integer> bsTree = new BinarySortTree<>();
        Integer a[] = {99, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 56, 45, 180, 17};
        bsTree.initTree(a);
        bsTree.delete(99);
        bsTree.inOrderTraverse(bsTree.getRoot());
    }
}
