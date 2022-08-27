package com.zp.leetcode.package_2022.august.august27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengpeng
 * @date 2022/8/27 10:36 下午
 * 二叉树的最大宽度
 **/
public class WidthOfBinaryTree {


    /**
     * 思路
     * 将二叉树的下标存储到数组中、根节点的下标为1，左子树的节点为 2 * i、右子树的下标为 2 * i + 1
     * 然后我们层次遍历、每次比较最大宽度
      * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        list.add(1);
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                final TreeNode poll = queue.poll();
                Integer curIndex = list.removeFirst();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(curIndex * 2);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                    list.add(curIndex * 2 + 1);
                }
                if(list.size() >= 2){
                    result = Math.max(result,list.getLast() - list.getFirst() + 1);
                }
            }
        }
        return result;
    }

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = count; i > 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if (cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;

    }


     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

}
