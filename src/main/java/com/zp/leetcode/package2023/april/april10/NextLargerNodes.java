package com.zp.leetcode.package2023.april.april10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/4/10 8:52 上午
 * 链表中的下一个更大节点
 **/
public class NextLargerNodes {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        NextLargerNodes nextLargerNodes = new NextLargerNodes();
        int[] ints = nextLargerNodes.nextLargerNodes(node1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<int[]> stack = new ArrayDeque<int[]>();
        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                int index = stack.pop()[1];
                ans.set(index, cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }
        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}

class ListNode {
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