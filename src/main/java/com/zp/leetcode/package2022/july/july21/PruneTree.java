package com.zp.leetcode.package2022.july.july21;

/**
 * @author zhengpeng
 * @date 2022/7/21 10:34 上午
 * 二叉树减枝
 **/
public class PruneTree {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //子节点，且值等于0
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
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



