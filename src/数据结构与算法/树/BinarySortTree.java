package 数据结构与算法.树;

/**
 * @Description 二叉排序树
 * @Author J
 * @Date 2018/7/5 11:46
 **/
public class BinarySortTree<T extends Comparable<? super T>> extends BinaryTree<T> {

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
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = node;
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
        if (root == null) {
            return false;
        }
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> node = null;
        BinaryTreeNode<T> parent = null;
        while (true) {
            int flag = t.compareTo(current.nodeData);
            if (flag == 0) {
                node = current;
                break;
            } else if (flag > 0) {
                parent = current;
                current = current.right;
            } else {
                parent = current;
                current = current.left;
            }

            if (current == null) {
                break;
            }
        }
        if (node == null) {
            return false;
        }

        BinaryTreeNode<T> left = node.left;
        BinaryTreeNode<T> right = node.right;
        BinaryTreeNode<T> temp;

        //如果左子树和右子树均为null，直接删除该节点，
        // 由于java没有指针这一概念，只能把该节点的父节点对它的引用设为null
        if (left == null && right == null) {
            temp = parent;
            //若没有父节点，则表示为根节点，且该树只有一个根节点
            if (temp == null) {
                node.nodeData = null;
                return true;
            }

            //与其父节点比较，判断是左子树还是右子树
            int flag = node.nodeData.compareTo(temp.nodeData);
            if (flag <= 0) {
                temp.left = null;
            } else {
                temp.right = null;
            }
            return true;
        }

        //若左子树为空，则直接将右子树连到要删除的节点
        //右子树为空时同理
        if (left == null) {
            this.recover(node, node.right);
        } else if (right == null) {
            this.recover(node, node.left);
        } else {
            //左右子树均不为空时
            temp = node;
            //后继为右子树的最左的节点
            temp = temp.right;
            //若右子树没有左子树,直接将右子树的根节点覆盖到当前节点
            if (temp.left == null) {
                node.nodeData = temp.nodeData;
                node.right = temp.right;
            } else {
                //找到右子树的最左节点
                while (temp.left != null) {
                    parent = temp;
                    temp = temp.left;
                }
                //将最左节点的数据覆盖至删除节点
                node.nodeData = temp.nodeData;
                //将其父节点对最左节点的引用置为null
                parent.left = null;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        BinarySortTree<Integer> bsTree = new BinarySortTree<>();
        Integer a[] = {99, 10, 7, 20, 17, 30, 40, 110, 120};
        bsTree.initTree(a);
        bsTree.delete(7);
        bsTree.inOrderTraverse(bsTree.getRoot());
        System.out.println("-------------------------------------");
        System.out.println("root: " + bsTree.getRoot());
    }
}
