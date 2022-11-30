package com.zp.leetcode.package2022.november.november30;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/11/30 9:20 上午
 * 最大频率栈
 **/
public class FreqStack {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }


    private Map<Integer,Integer> freq;
    private Map<Integer, Deque<Integer>> group;
    private int maxFreq;

    /**
     * 构造函数
     */
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    /**
     * 入栈
     * @param val
     */
    public void push(int val) {

        freq.put(val,freq.getOrDefault(val,0) + 1);
        group.putIfAbsent(freq.get(val),new ArrayDeque<Integer>());
        Deque<Integer> integers = group.get(freq.get(val));
        integers.push(val);
        maxFreq = Math.max(maxFreq,freq.get(val));

    }

    public int pop() {
        int val = group.get(maxFreq).peek();
        freq.put(val,freq.get(val) - 1);
        group.get(maxFreq).pop();
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }


}
