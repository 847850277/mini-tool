package com.zp.leetcode.package2023.july.july31;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/7/31 09:24
 * 重排链表
 **/

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null){
            list.add(node);
            node = node.next;
        }
        int i = 0,j = list.size() - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if(i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
