package leetcode;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author J
 * @time 2018/10/15 21:28
 * @description
 **/
public class _102_二叉树层次遍历 {
    /**
     * 网页手敲一次通过
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack stack = new Stack();
        stack.si
        queue.offer(root);
        while (true) {
            int count = queue.size();
            List<Integer> innerList = new ArrayList<>(count);
            while (count-- > 0) {
                TreeNode item = queue.poll();
                innerList.add(item.val);
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }
            list.add(innerList);
            if (queue.isEmpty()) {
                return list;
            }
        }
    }


    /**
     * 103
     *
     * @param root
     * @return 输入
     * [1,2,3,4,null,null,5]
     * 输出
     * [[1],[3,2],[5,4]]
     * 预期结果
     * [[1],[3,2],[4,5]]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (true) {
            int count = queue.size();
            List<Integer> innerList = new ArrayList<>(count);
            i++;
            while (count-- > 0) {
                TreeNode item = queue.poll();
                innerList.add(item.val);
                if (i % 2 == 1) {
                    if (item.right != null) {
                        queue.offer(item.right);
                    }
                    if (item.left != null) {
                        queue.offer(item.left);
                    }
                } else {
                    if (item.left != null) {
                        queue.offer(item.left);
                    }
                    if (item.right != null) {
                        queue.offer(item.right);
                    }
                }

            }
            list.add(innerList);
            if (queue.isEmpty()) {
                return list;
            }
        }
    }
}
