package com.zp.leetcode.package_2022.may.may16;

/**
 * @author zhengpeng
 * @date 2022/5/16 10:31 上午
 * 删除链表指定节点
 **/
public class DeleteSpecifiedNode {

    /**
     * 删除链表指定节点
     * @param node 指定节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }

}

/**
 * 链表对象
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
