package com.zp.leetcode.package2022.september.september23;

/**
 * @author zhengpeng
 * @date 2022/9/23 11:09 上午
 * 设计链表
 **/
public class MyLinkedList {


    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtHead(4);
        linkedList.addAtTail(6);

        final int i = linkedList.get(0);
        System.out.println(i);
        System.out.println("111");

    }


    private int size;

    private Node linkedList;

    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * 获取链表第index个节点值,如果索引无效，返回-1
     * @param index
     * @return
     */
    public int get(int index) {
        if(index > size || index < 0){
            return -1;
        }
        Node cur = linkedList;
        for (int i = 0; i < size; i++) {
            if(index == i){
                return cur.val;
            }else {
                cur = cur.next;
            }
        }
        return -1;
    }

    /**
     * 在链表第一个元素之前添加一个值为val的节点。
     * 插入后新节点将成为链表的第一个节点
     * @param val
     */
    public void addAtHead(int val) {
        //新增一个节点
        Node node = new Node(val);
        //原来节点有数据
        if(size != 0){
            node.next = linkedList;
        }
        //设置值到当前节点
        this.linkedList = node;
        size++;
    }

    /**
     * 将值为val的添加到链表的末尾
     * @param val
     */
    public void addAtTail(int val) {
       addAtIndex(size,val);
    }

    /**
     * 将值val添加到索引为index的位置
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        //新节点设置到指定位置
        Node node = new Node(val);
        Node pre = linkedList;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        node.next = pre.next;
        pre.next = node;
        size++;
    }

    /**
     * 删除对映索引的值，同时下一个索引指向该节点
     * @param index
     */
    public void deleteAtIndex(int index) {

        if(index < 0 || index > size) {
            return;
        }
        if(index == 0){
            linkedList = linkedList.next;
            size--;
        }else {
            Node cur = linkedList;
            for (int i = 0; i < index - 1; i++){
                //找到索引的前驱动位置
                cur = cur.next;
            }
            if(cur.next != null){
                cur.next = cur.next.next;
                size--;
            }
        }
    }


    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
        Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
