package com.zp.leetcode.package2022.june.june24;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/24 10:14 上午
 * 在每个树行中找最大值
 * 二叉树广度优先遍历
 **/
public class LargestValues {


    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> stack = new ArrayDeque<>();
        if(root != null){
            stack.add(root);
        }
        while(!stack.isEmpty()){
            int size = stack.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                final TreeNode peek = stack.peek();
                max = Math.max(max, peek.val);
                if(peek.left != null){
                    stack.add(peek.left);
                }
                if(peek.right != null){
                    stack.add(peek.right);
                }
                stack.poll();
            }
            result.add(max);
        }

        return result;
    }




    public static void main(String[] args) {
        LargestValues largestValues = new LargestValues();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);

        TreeNode leafLeftLeft = new TreeNode(5);
        TreeNode leafLeftRight = new TreeNode(3);

        TreeNode leafRightRight = new TreeNode(9);

        root.left = left;
        root.right = right;

        left.left = leafLeftLeft;
        left.right = leafLeftRight;

        right.right = leafRightRight;

        System.out.println(largestValues.largestValues(root));

    }

}


class TreeNode {
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