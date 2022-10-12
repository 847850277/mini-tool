package com.zp.leetcode.package2022.october.october12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2022/10/12 9:21 上午
 * 链表组建
 **/
public class NumComponents {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //int[] array = new int[]{0,1,3};
        int[] array = new int[]{0,3,1,4};

        NumComponents n = new NumComponents();
        System.out.println(n.numComponents(node0,array));



    }

    /**
     * 返回这个链表的组件个数
     * @param head
     * @param nums
     * @return
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }




    /**
     * 返回这个链表的组件个数
     * @param head
     * @param nums
     * @return
     */
//    public int numComponents(ListNode head, int[] nums) {
//
//        //排序
//        Arrays.sort(nums);
//        int count  = 0;
//        int index = 0;
//        ListNode cur = head;
//        while (cur != null) {
//            int val = cur.val;
//            int num = nums[index];
//            if(val != num) {
//                count++;
//            }
//            cur = cur.next;
//            if(index < nums.length - 1){
//                index++;
//            }
//        }
//        return count == 0 ? 1: count + 1;
//    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
