package com.zp.leetcode.package2023.july.july14;

/**
 * @author zhengpeng
 * @date 2023/7/14 11:34
 * 在二叉树中分配硬币
 **/
public class DistributeCoins {

    int move = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    private int dfs(TreeNode root) {
        int moveLeft = 0;
        int moveRight = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null){
            moveLeft = dfs(root.left);
        }
        if(root.right != null){
            moveRight = dfs(root.right);
        }
        move += Math.abs(moveLeft) + Math.abs(moveRight);
        return moveLeft + moveRight + root.val - 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
