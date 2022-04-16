package com.zp.leetcode.package_20220414;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhengpeng
 * @date 2022-04-14 16:58
 * 删除链表重复元素
 **/
public class RemoveDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode pointer = head;
        ListNode pre = null;
        while (pointer.next != null){
//            if(map.containsKey(pointer.val)){
//                //指向下下一个节点
//                pointer = pointer.next.next ;
//            }else {
//                map.put(pointer.val,pointer.val);
//                //结尾特殊情况处理
//                if(Objects.isNull(pointer.next) && map.containsKey(pointer.next.val)){
//                    pointer.next = null;
//                }else {
//                    //链表后移动
//                    pointer = pointer.next;
//                }
//
//            }

            pointer = pointer.next;



        }
        return pre;
    }

    /*

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
    */



    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        //ListNode listNode4 = new ListNode(1);
        //listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.deleteDuplicates(listNode));


    }

    @Data
    public static class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
