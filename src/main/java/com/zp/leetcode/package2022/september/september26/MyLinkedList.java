package com.zp.leetcode.package2022.september.september26;

/**
 * @author zhengpeng
 * @date 2022/9/26 9:01 上午
 * 设计链表
 **/
public class MyLinkedList {

    private Node linkedList;

    private Integer size;

    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * 获取指定元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        Node cur = linkedList;
        for (int i = 0; i < size; i++) {
            if(i == index) {
                return cur.val;
            }else {
                cur = cur.next;
            }
        }
        return -1;
    }

    /**
     * 添加头节点
     *
     * @param val
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0) {
            this.linkedList = node;
        } else {
            node.next = linkedList;
            this.linkedList = node;
        }
        size++;
    }

    /**
     * 添加到尾节点
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 添加到指定位置的节点
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            Node node = new Node(val);
            Node cur = linkedList;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            //把node节点插入进去
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    /**
     * 删除指定节点元素
     *
     * @param index
     */
    public void deleteAtIndex(int index) {

        //下标位置不合法
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            linkedList = linkedList.next;
            size--;
        } else {
            Node cur = linkedList;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
                size--;
            }
        }
    }


    public static class Node {

        private int val;

        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

}
