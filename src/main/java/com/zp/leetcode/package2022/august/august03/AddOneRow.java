package com.zp.leetcode.package2022.august.august03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/8/5 4:39 下午
 * 在二叉树中增加一行
 **/
public class AddOneRow {


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

    public static void main(String[] args) {

    }



    public TreeNode addOneRow (TreeNode root,int val, int depth){
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                } else {
                    if (t.left != null) d.addLast(t.left);
                    if (t.right != null) d.addLast(t.right);
                }
            }
            cur++;
        }
        return root;
    }
}
