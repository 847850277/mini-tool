package com.zp.leetcode.package2023.june.june14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/6/14 15:18
 * 二进制字符串前缀一致的次数
 **/
public class NumTimesAllBlue {

    public static void main(String[] args) {

        //int[] arrays = new int[]{3,2,4,1,5};
        int[] arrays = new int[]{4,1,2,3};
        NumTimesAllBlue numTimesAllBlue = new NumTimesAllBlue();
        System.out.println(numTimesAllBlue.numTimesAllBlue(arrays));

    }

    public int numTimesAllBlue1(int[] flips) {
        int n = flips.length;
        int ans = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                ++ans;
            }
        }
        return ans;
    }


    public int numTimesAllBlue(int[] flips) {
        int len = flips.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("0");
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            int flip = flips[i];
            sb.replace(flip - 1,flip,"1");
            if(isStartWith(sb)){
                count++;
            }
        }
        return count;
    }

    private boolean isStartWith(StringBuilder sb) {
        int length = sb.length();
        boolean containsOne = false;

        for(int i = 0; i < length; i++) {

        }
        return true;

    }

}
