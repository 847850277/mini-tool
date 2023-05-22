package com.zp.leetcode.package2023.may.may22;

/**
 * @author zhengpeng
 * @date 2023/5/22 9:15 上午
 * 根到叶路径上的不足节点
 **/
public class SufficientSubset {

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


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean haveSufficient = checkSufficientLeaf(root,0,limit);
        return haveSufficient ? root : null;
    }

    private boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }
        boolean haveSufficientLeft = checkSufficientLeaf(node.left, sum + node.val, limit);
        boolean haveSufficientRight = checkSufficientLeaf(node.right, sum + node.val, limit);
        if (!haveSufficientLeft) {
            node.left = null;
        }
        if (!haveSufficientRight) {
            node.right = null;
        }
        return haveSufficientLeft || haveSufficientRight;
    }

}
