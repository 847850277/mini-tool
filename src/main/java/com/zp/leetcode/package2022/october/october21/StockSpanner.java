package com.zp.leetcode.package2022.october.october21;

import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/10/21 9:06 上午
 * 股票价格跨度
 **/
public class StockSpanner {


    public static void main(String[] args) {
        StockSpanner spanners = new StockSpanner();
        System.out.println(spanners.next(100));
        System.out.println(spanners.next(80));
        System.out.println(spanners.next(60));
        System.out.println(spanners.next(70));
        System.out.println(spanners.next(60));
        System.out.println(spanners.next(75));
        System.out.println(spanners.next(85));
    }

    Stack<Integer> prices, weights;
    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }



}
