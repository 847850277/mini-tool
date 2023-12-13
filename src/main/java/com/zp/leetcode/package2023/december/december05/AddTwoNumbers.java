package com.zp.leetcode.package2023.december.december05;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList();
        while (l1 != null){
            queue1.add(l1.val);
            l1 = l1.next;
        }
        Queue<Integer> queue2 = new LinkedList();
        while (l2 != null){
            queue2.add(l2.val);
            l2 = l2.next;
        }
        int maxSize = Math.max(queue1.size(), queue2.size());
        ListNode result = new ListNode();
        ListNode cur = result;
        boolean needCarry = false;
        for (int i = 0; i < maxSize; i++) {
            Integer i1 = queue1.isEmpty() ? 0 : queue1.poll();
            Integer i2 = queue2.isEmpty() ? 0 : queue2.poll();
            int i3 = i1 + i2;
            if(needCarry){
                i3++;
                needCarry = false;
            }
            int val = i3 % 10;
            if(i3 >= 10){
                needCarry = true;
            }
            ListNode v = new ListNode(val);
            cur.next = v;
            cur = cur.next;
        }
        if(needCarry){
            ListNode v = new ListNode(1);
            cur.next = v;
        }
        return result.next;
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
