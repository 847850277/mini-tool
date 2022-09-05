package com.zp.leetcode.package2022.july.july26;

import java.util.Random;

/**
 * @author zhengpeng
 * @date 2022/7/26 1:55 下午
 * 设计跳表
 * https://www.bilibili.com/video/BV1gN4y1T7hd
 **/
public class Skiplist {
    /**
     * 层级，最高10层
     */
    int level = 10;
    class Node {
        int val;
        Node[] datas = new Node[level];
        public Node(int val) {
            this.val = val;
        }
    }
    Random random = new Random();
    Node head = new Node(-1);

    public static void main(String[] args) {

        Skiplist skiplist = new Skiplist();
        skiplist.add(26);
        skiplist.add(25);
        skiplist.add(3);
        skiplist.add(6);
        skiplist.add(9);
        skiplist.add(21);
        skiplist.add(19);
        skiplist.add(7);
        skiplist.add(12);

        skiplist.search(9);
        skiplist.add(17);
        skiplist.search(17);

    }


    public boolean search(int target) {
        Node[] ns = new Node[level];
        find(target,ns);
        return ns[0].datas[0] != null && ns[0].datas[0].val == target;
    }

    public void add(int num) {
        Node[] ns = new Node[level];
        find(num,ns);
        Node node = new Node(num);
        for(int i = 0; i < level;i++){
            node.datas[i] = ns[i].datas[i];
            ns[i].datas[i] = node;
            if(random.nextInt() == 2){
                break;
            }
        }
    }

    private void find(int num, Node[] ns) {
        Node cur = head;
        for(int i = level - 1; i >= 0; i--){
            while (cur.datas[i] != null && cur.datas[i].val < num){
                cur = cur.datas[i];
            }
            ns[i] = cur;
        }
    }

    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].datas[0];
        if (node == null || node.val != t) {
            return false;
        }
        for (int i = 0; i < level && ns[i].datas[i] == node; i++){
            ns[i].datas[i] = ns[i].datas[i].datas[i];
        }
        return true;
    }

}
