package com.zp.leetcode.package2023.september.september20;

/**
 * 拿硬币
 */
public class MinCount {


    public static void main(String[] args) {
        int[] array = new int[]{4,2,1};
        //int[] array = new int[]{2,3,10};
        //int[] array = new int[]{1,5,5,6};
        MinCount minCount = new MinCount();
        System.out.println(minCount.minCount(array));

    }


    public int minCount(int[] coins) {
        int sum = 0;
        for (int coin : coins) {
            while (coin > 0){
                sum++;
                coin = coin - 2;
            }
        }
//        int divide = sum / 2;
//        int remainder = sum % 2;
//        return divide + remainder;
        return sum;
    }
}
