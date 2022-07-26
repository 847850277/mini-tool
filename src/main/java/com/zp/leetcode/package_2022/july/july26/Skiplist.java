package com.zp.leetcode.package_2022.july.july26;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhengpeng
 * @date 2022/7/26 1:55 下午
 * 设计跳表
 **/
public class Skiplist {

    public static class SkiplistNode{

        int val;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            this.forward = new SkiplistNode[maxLevel];
        }
    }


    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.add(4);
        skiplist.add(5);
        skiplist.add(6);
        skiplist.add(7);
        skiplist.add(8);
        skiplist.add(9);
        skiplist.add(10);
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.add(4);
        skiplist.add(5);
        skiplist.add(6);
        skiplist.add(7);
        skiplist.add(8);
        skiplist.add(9);
        skiplist.add(10);



    }

    static final int MAX_LEVEL = 32;
    static final double P_FACTOR = 0.25d;

    private SkiplistNode head;
    private int level;
    private Random random;

    /**
     * 构造函数
     */
    public Skiplist() {
        this.head = new SkiplistNode(-1,MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    /**
     * 添加元素
     * @param num
     */
    public void add(int num) {
        SkiplistNode[] update  = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update,head);
        SkiplistNode curr = this.head;
        for(int i = level; i >= 0; i--){
            //找到第i层小于且最接近num的元素
            while(curr.forward[i] != null && curr.forward[i].val < num){
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        int lv = randomLevel();
        level = Math.max(level,lv);
        SkiplistNode newNode = new SkiplistNode(num,lv);
        for (int i = 0;i < lv;i++){
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    /**
     * 随机层数
     * @return
     */
    private int randomLevel() {
        int lv = 1;
        while(random.nextDouble() < P_FACTOR && lv < MAX_LEVEL){
            lv++;
        }
        return lv;
    }

    public boolean search(int target) {
        return false;
    }



    public boolean erase(int num) {
        return false;
    }
}
