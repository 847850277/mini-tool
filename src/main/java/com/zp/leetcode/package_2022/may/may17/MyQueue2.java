package com.zp.leetcode.package_2022.may.may17;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhengpeng
 * @date 2022/5/17 1:07 下午
 **/
public class MyQueue2 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue2() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();

        System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }
}
