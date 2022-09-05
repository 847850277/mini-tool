package com.zp.leetcode.package2022.august.august27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengpeng
 * @date 2022/8/27 10:36 下午
 * 二叉树的最大宽度
 **/
public class WidthOfBinaryTree {


    public static void main(String[] args) {
        WidthOfBinaryTree tree = new WidthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);

        root.left = node_3;
        root.right = node_2;
        node_3.left = node_5;
        node_5.left = node_6;
        node_2.right = node_9;
        node_9.left = node_7;

        //System.out.println(tree.widthOfBinaryTree(root));
        //System.out.println(tree.widthOfBinaryTree1(root));
        //Integer[] array = new Integer[]{1,2,3,4,5};
        Integer[] array = new Integer[]{1,3,2,5,null,null,9,6,null,7};
        final TreeNode convert = arrayToTreeNode(array);
        System.out.println(tree.widthOfBinaryTree(convert));
        System.out.println(tree.widthOfBinaryTree1(convert));


    }


    /**
     * 思路
     * 将二叉树的下标存储到数组中、根节点的下标为1，左子树的节点为 2 * i、右子树的下标为 2 * i + 1
     * 然后我们层次遍历、每次比较最大宽度
      * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        list.add(1);
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                final TreeNode poll = queue.poll();
                Integer curIndex = list.removeFirst();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(curIndex * 2);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                    list.add(curIndex * 2 + 1);
                }
                if(list.size() >= 2){
                    result = Math.max(result,list.getLast() - list.getFirst() + 1);
                }
            }
        }
        return result;
    }

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = count; i > 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if (cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;

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


    public static TreeNode arrayToTreeNode(Integer[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

}
