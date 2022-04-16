package com.zp.leetcode.package_20220417;

import lombok.ToString;

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









        return false;
    }


    public static void main(String[] args) {

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
