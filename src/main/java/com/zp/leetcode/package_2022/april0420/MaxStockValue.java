package com.zp.leetcode.package_2022.april0420;

/**
 * @author zhengpeng
 * @date 2022-04-20 09:18
 * 买卖股票的最大时机
 **/
public class MaxStockValue {


    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int length = prices.length;
        int slow = 0;
        //最大利润值
        int maxProfit = 0;
        //每一层循环都是当前数组的最大值
        for (int i = slow; i < length; i++) {
            maxProfit  = getSubArrayMaxProfit(maxProfit,i,prices);
        }
        return maxProfit;
    }

    /**
     * 获取子数组的最大利润
     * @param maxProfit
     * @param i
     * @param prices
     * @return
     */
    private int getSubArrayMaxProfit(int maxProfit, int i, int[] prices) {

        for (int j = i; j < prices.length; j++) {
            maxProfit = Math.max(maxProfit,prices[j] - prices[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        //int[] array = new int[]{7,1,5,3,6,4};
        int[] array = new int[]{7,1,5,3,6,4};
        //int[] array = new int[]{7,6,5,4,3,2,1};
        //int[] array = new int[]{1,2};

        MaxStockValue maxStockValue = new MaxStockValue();
        System.out.println(maxStockValue.maxProfit(array));
    }




}
