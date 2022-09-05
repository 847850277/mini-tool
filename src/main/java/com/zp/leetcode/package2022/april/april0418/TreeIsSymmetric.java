package com.zp.leetcode.package2022.april.april0418;

import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengpeng
 * @date 2022-04-16 17:29
 * 是镜像树
 **/
public class TreeIsSymmetric {

    /**
     * 是对称二叉树
     * 叶子节点，左边和右边反过来，非叶子节点，值想通
     * 用栈遍历
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }


    public static void main(String[] args) {



        TreeIsSymmetric symmetric = new TreeIsSymmetric();

        TreeNode treeNode = new TreeNode(1);

        System.out.println(symmetric.isSymmetric(treeNode));


    }


    @ToString
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
