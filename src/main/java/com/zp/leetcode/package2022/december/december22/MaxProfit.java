package com.zp.leetcode.package2022.december.december22;

/**
 * @author zhengpeng
 * @date 2022/12/22 3:19 下午
 **/
public class MaxProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
