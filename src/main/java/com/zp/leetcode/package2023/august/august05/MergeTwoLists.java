package com.zp.leetcode.package2023.august.august05;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode node1_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        ListNode node3_3 = new ListNode(3);
        ListNode node4_4 = new ListNode(4);


        node1_1.next = node2_2;
        node2_2.next = node3_3;
        node3_3.next = node4_4;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(node1, node1_1);
        System.out.println(listNode);

    }



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> priority = new PriorityQueue<Integer>(Comparator.naturalOrder());
        while (list1 != null){
            priority.offer(list1.val);
            list1 = list1.next;
        }
        while (list2 != null){
            priority.offer(list2.val);
            list2 = list2.next;
        }
        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        while (priority.peek() != null){
            curr.next = new ListNode(priority.poll());
            curr = curr.next;
        }
        return preHead.next;
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
