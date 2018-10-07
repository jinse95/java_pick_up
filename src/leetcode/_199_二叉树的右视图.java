package leetcode;

import java.util.*;

/**
 * @Description 考察二叉树按层次遍历
 * @Author J
 * @Date 2018/9/29 16:40
 **/
public class _199_二叉树的右视图 {
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.val);

        while (true) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            Integer last = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    tempQueue.offer(node.left);
                    last = node.left.val;
                }
                if (node.right != null) {
                    tempQueue.offer(node.right);
                    last = node.right.val;
                }
            }
            if (tempQueue.isEmpty()) {
                break;
            }
            queue = tempQueue;
            list.add(last);
        }

        return list;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {

    int val;
    TreeNode left;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


}