package com.zp.leetcode.package2022.june.june13;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/6/13 11:38 上午
 * 高度检查器
 **/
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        System.arraycopy(heights,0,temp,0,heights.length);
        Arrays.sort(heights);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if(temp[i] != heights[i]){
                sum++;
            }
        }
        return sum;
    }


    public static void main(String[] args) {



    }

}
