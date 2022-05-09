package com.zp.leetcode.package_2022.may.may09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengpeng
 * @date 2022-05-09 09:01
 * 用队列实现栈
 **/
public class MyStack {


    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        moveToBack();
        return queue.poll();
    }

    public int top() {
        moveToBack();
        int top = queue.poll();
        queue.add(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void moveToBack() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) queue.add(queue.poll());
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
    }
}
