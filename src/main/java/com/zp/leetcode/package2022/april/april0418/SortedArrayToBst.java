package com.zp.leetcode.package2022.april.april0418;

import lombok.ToString;

/**
 * @author zhengpeng
 * @date 2022-04-18 09:44
 * //TODO
 **/
public class SortedArrayToBst {


    @ToString
    public static class TreeNode {
        int val;
        TreeIsSymmetric.TreeNode left;
        TreeIsSymmetric.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeIsSymmetric.TreeNode left, TreeIsSymmetric.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 有序数组转二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {




        return null;
    }

    public static void main(String[] args) {

    }
}
