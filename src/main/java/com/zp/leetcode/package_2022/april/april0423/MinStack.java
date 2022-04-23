package com.zp.leetcode.package_2022.april.april0423;

import lombok.ToString;

/**
 * @author zhengpeng
 * @date 2022-04-22 09:36
 * 最小栈
 **/
@ToString
public class MinStack {

    private int[] array;
    private int size;

    public MinStack() {
        array = new int[]{};
        size = 0;
    }

    /**
     * 入栈，数组长度+1，且尾部加一个元素
     * @param val
     */
    public void push(int val) {

        int[] temp = new int[size];
        System.arraycopy(array,0,temp,0, (int) size);
        //栈的长度++;
        size++;
        array = new int[size];
        System.arraycopy(temp,0,array,0, (size - 1));
        array[size - 1] = val;
    }

    /**
     * 出栈，数组长度-1，且头部出一个元素
     */
    public void pop() {

        if(size <= 0){
            //throw new RuntimeException("栈内");
            return;
        }

        int[] temp = new int[size];
        System.arraycopy(array,0,temp,0,  size);
        //栈的长度++;
        size--;
        array = new int[size];
        System.arraycopy(temp,0,array,0, (size));
    }

    /**
     * 返回数组下标[0]的值
     * @return
     */
    public int top() {
        return array[size - 1];

    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for (int l : array) {
            minValue  = Math.min(minValue, l);
        }
        return minValue;
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        //System.out.println(minStack);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
