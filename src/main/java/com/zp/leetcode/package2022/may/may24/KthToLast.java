package com.zp.leetcode.package2022.may.may24;

/**
 * @author zhengpeng
 * @date 2022/5/24 4:00 下午
 * 返回倒数第K个节点
 **/
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q!=null) {
            q = q.next;
            p = p.next;
        }
        return p.val;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
