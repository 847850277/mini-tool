package com.zp.leetcode.package2023.may.may30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2023/5/30 11:02 上午
 * 删点成林
 **/
public class DelNodes {

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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : to_delete) {
            map.put(i,i);
        }
        List<TreeNode> result = new ArrayList<>();
        dfs(root,true,map,result);
        return result;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot, Map<Integer, Integer> map, List<TreeNode> result) {
        if(node == null){
            return null;
        }
        boolean contains = map.containsKey(node.val);
        node.left = dfs(node.left,contains,map,result);
        node.right = dfs(node.right,contains,map,result);
        if(contains){
            return null;
        }else {
            if(isRoot){
                result.add(node);
            }
            return node;
        }

    }

}
