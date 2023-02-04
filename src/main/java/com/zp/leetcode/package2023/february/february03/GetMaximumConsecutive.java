package com.zp.leetcode.package2023.february.february03;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/2/4 9:40 上午
 **/
public class GetMaximumConsecutive {

    public static void main(String[] args) {

    }

    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if(coin > res){
                break;
            }
            res += coin;
        }
        return res;
    }
}
