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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
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
     * 103 锯齿输出   双端队列
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int i = 0;
        while (true) {
            int count = queue.size();
            List<Integer> innerList = new ArrayList<>(count);
            i++;
            if (i % 2 == 0) {
                while (count-- > 0) {
                    TreeNode item = queue.pollFirst();
                    innerList.add(item.val);
                    if (item.right != null) {
                        queue.addLast(item.right);
                    }

                    if (item.left != null) {
                        queue.addLast(item.left);
                    }
                }
            } else {
                while (count-- > 0) {
                    TreeNode item = queue.pollLast();
                    innerList.add(item.val);
                    if (item.left != null) {
                        queue.addFirst(item.left);
                    }
                    if (item.right != null) {
                        queue.addFirst(item.right);
                    }
                }
            }

            list.add(innerList);
            if (queue.isEmpty()) {
                return list;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(new int[]{1, 2, 3, 4, -1, -1, 5, 6, -1, -1, 7});
        List<List<Integer>> list = zigzagLevelOrder(root);
        for (List<Integer> itemList : list) {
            for (Integer item : itemList) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
