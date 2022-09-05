package com.zp.leetcode.package2022.may.may17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/5/16 9:11 上午
 * 用两个栈实现队列
 **/
public class MyQueue {

    //private Stack stack;

    //TODO 先用集合实现
    private List<Integer> list;

    public MyQueue() {
        list = new ArrayList();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int val = list.get(0);
        //移除元素
        list.remove(0);
        return val;

    }

    public int peek() {
        int val = list.get(0);
        return val;
    }

    public boolean empty() {
        if(list != null && list.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        System.out.println(myQueue.empty());

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }
}
