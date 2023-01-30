package com.zp.leetcode.package2023.january.january30;

/**
 * @author zhengpeng
 * @date 2023/1/30 9:12 上午
 * 合并两个链表
 **/
public class MergeInBetween {

    public static void main(String[] args) {



    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pointer = list1;
        for (int i = 0; i < a - 1; i++) {
            pointer = pointer.next;
        }
        ListNode pointerB = pointer;
        for (int i = 0; i < b - a + 2; i++) {
            pointerB = pointerB.next;
        }
        pointer.next = list2;
        while (list2.next != null){
            list2 = list2.next;
        }
        list2.next = pointerB;
        return list1;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

