package leetcode;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author J
 * @time 2018/10/2 21:02
 * @description
 **/
public class _863_二叉树中所有距离为K的结点 {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        preOrderTraverse(root, null, parentMap);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        preOrderTraverse(root, 5, target);
        nodeQueue.add(target);
        while (!parentMap.isEmpty() && K-- > 0) {
            int count = nodeQueue.size();
            while (count-- > 0) {
                TreeNode temp = nodeQueue.poll();
                if (temp.left != null && parentMap.containsKey(temp.left)) {
                    nodeQueue.add(temp.left);
                }
                if (temp.right != null && parentMap.containsKey(temp.right)) {
                    nodeQueue.add(temp.right);
                }
                temp = parentMap.remove(temp);
                if (temp != null && parentMap.containsKey(temp)) {
                    nodeQueue.add(temp);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (TreeNode item : nodeQueue) {
            result.add(item.val);
        }
        return result;
    }

    public static void preOrderTraverse(TreeNode root, TreeNode parentNode, Map<TreeNode, TreeNode> parentMap) {
        if (root != null) {
            parentMap.put(root, parentNode);
            preOrderTraverse(root.left, root, parentMap);
            preOrderTraverse(root.right, root, parentMap);
        }
    }

    public static void preOrderTraverse(TreeNode root, int val, TreeNode getNode) {
        if (root != null) {
            if (root.val == val) {
                getNode.val = root.val;
                getNode.left = root.left;
                getNode.right = root.right;
                return;
            }
            preOrderTraverse(root.left, val, getNode);
            preOrderTraverse(root.right, val, getNode);
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        System.out.println("=====init");

        List<Integer> result = distanceK(root, new TreeNode(5), 2);
//        TreeNode get = new TreeNode(0);
//        preOrderTraverse(root, 5, get);
        System.out.println(result);
    }


}

