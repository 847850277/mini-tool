package com.zp.leetcode.package2023.july.july01;

import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2023/7/3 09:42
 * 两数相加
 **/
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
//        ListNode node1 = new ListNode(7);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(4);
//        node1.next.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);





        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(node1, node2);


    }




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用栈暂存
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        //反转链表
        int size = Math.max(stack1.size(),stack2.size());
        int s1Size = stack1.size();
        int s2Size = stack2.size();
        //遍历链表，设置值
        ListNode head = new ListNode(0);
        ListNode top = head;
        int[] array = new int[size];
        boolean needCarry = false;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            int s1 = 0;
            int s2 = 0;
            if(i < s1Size){
                s1 = stack1.pop();
            }
            if(i < s2Size){
                s2 = stack2.pop();
            }
            if(needCarry){
                sum += 1;
            }
            sum += s1 + s2 ;
            if(sum == 10){
                sum = 0;
                needCarry = true;
            }else {
                needCarry = false;
            }
            array[size - i - 1] = sum;
        }
        //特殊需要进位的场景
        if(needCarry){
           int[] newArray = new int[array.length + 1];
        }
        for (int i : array) {
            ListNode curr = new ListNode(i);
            head.next = curr;
            head = head.next;
        }

        return top.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
