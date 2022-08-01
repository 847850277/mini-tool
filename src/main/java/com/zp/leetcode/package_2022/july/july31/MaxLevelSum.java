package com.zp.leetcode.package_2022.july.july31;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhengpeng
 * @date 2022/7/31 3:31 下午
 * 最大层内元素和
 **/
public class MaxLevelSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(0);
        TreeNode leftLeft = new TreeNode(7);
        TreeNode leftRight = new TreeNode(-8);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;

        MaxLevelSum maxLevelSum = new MaxLevelSum();
        System.out.println(maxLevelSum.maxLevelSum(root));
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

    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int index = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxIndex = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            index++;
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                sum += peek.val;
                if(peek.left != null){
                    queue.add(peek.left);
                }
                if(peek.right != null){
                    queue.add(peek.right);
                }
                queue.poll();
            }
            if(sum > maxSum){
                maxSum = sum;
                maxIndex = index;
            }
        }
        return maxIndex;
    }

}


