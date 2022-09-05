package com.zp.leetcode.package2022.june.june22;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/6/22 10:07 上午
 * 找树最左下角的值
 **/
public class FindBottomLeftValue {


    public int findBottomLeftValue(TreeNode root) {

        Deque<TreeNode> d = new ArrayDeque<TreeNode>();
        d.add(root);
        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            ans = d.peek().val;
            while(size-- > 0){
                TreeNode poll = d.pollFirst();
                if(poll.left != null){
                    d.addLast(poll.left);
                }
                if(poll.right != null){
                    d.addLast(poll.right);
                }

            }
        }
        return ans;
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
