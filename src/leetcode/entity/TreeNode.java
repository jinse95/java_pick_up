package leetcode.entity;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Description
 * @Author J
 * @Date 2018/10/10 16:41
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

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


    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode initTree(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> pQ = new LinkedList<>();
        pQ.add(root);

        for (int i = 1; i < array.length; i++) {
            while (!pQ.isEmpty()) {
                TreeNode temp = pQ.poll();

                int val = array[i++];
                if (val == -1) {
                    temp.left = null;
                } else {
                    temp.left = new TreeNode(val);
                    pQ.add(temp.left);
                }
                if (i >= array.length) {
                    break;
                }
                val = array[i++];
                if (val == -1) {
                    temp.right = null;
                } else {
                    temp.right = new TreeNode(val);
                    pQ.add(temp.right);
                }
                if (i >= array.length) {
                    break;
                }
            }
        }
        return root;
    }
}