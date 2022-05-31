package com.zp.leetcode.package_2022.may.may31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/5/30 10:54 上午
 * 从根到叶的二进制之和
 **/
public class SumRootToLeaf {

    /**
     * 遍历二叉树
      * @param root
     * @return
     */
   public int sumRootToLeaf(TreeNode root) {
       int ans = 0;
       Deque<TreeNode> d = new ArrayDeque<>();
       d.addLast(root);
       while (!d.isEmpty()) {
           TreeNode poll = d.pollFirst();
           if (poll.left != null) {
               poll.left.val = (poll.val << 1) + poll.left.val;
               d.addLast(poll.left);
           }
           if (poll.right != null) {
               poll.right.val = (poll.val << 1) + poll.right.val;
               d.addLast(poll.right);
           }
           if (poll.left == null && poll.right == null) ans += poll.val;
       }
       return ans;
   }


    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();

        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(1);
        //root.right = rootRight;
        root.left = rootLeft;
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        TreeNode leafLeftLeft = new TreeNode(0);
        TreeNode leafLeftRight = new TreeNode(1);
        TreeNode leafRightLeft = new TreeNode(0);
        TreeNode leafRightRight = new TreeNode(1);


        TreeNode lleafLeftLeft = new TreeNode(0);
        TreeNode lleafLeftRight = new TreeNode(1);
        //leafLeftLeft.left =   lleafLeftLeft;
        //leafLeftLeft.right =   lleafLeftRight;

        TreeNode lleafRightLeft = new TreeNode(0);
        TreeNode lleafRightRight = new TreeNode(1);
        //leafLeftRight.left =   lleafRightLeft;
        //leafLeftRight.right =   lleafRightRight;

        TreeNode rleafLeftLeft = new TreeNode(0);
        TreeNode rleafLeftRight = new TreeNode(1);
        //leafRightLeft.left =   rleafLeftLeft;
        //leafRightLeft.right =   rleafLeftRight;

        TreeNode rleafRightLeft = new TreeNode(0);
        TreeNode rleafRightRight = new TreeNode(1);
        //leafRightRight.left =   rleafRightLeft;
        //leafRightRight.right =   rleafRightRight;


        treeNode.left = left;
        treeNode.right = right;
        left.left = leafLeftLeft;
        left.right = leafLeftRight;
        right.left = leafRightLeft;
        right.right = leafRightRight;
        System.out.println(sumRootToLeaf.sumRootToLeaf(treeNode));
        //System.out.println(toBinaryString);
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
