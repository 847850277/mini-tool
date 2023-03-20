package com.zp.leetcode.package2023.march.march20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/3/20 9:11 上午
 * 至少有1位重复的数字
 **/
public class NumDupDigitsAtMostN {

    public static void main(String[] args) {
        NumDupDigitsAtMostN n = new NumDupDigitsAtMostN();
        //int number = 20;
        //int number = 100;
        //int number = 1000;
        int number = 1962;
        System.out.println(n.numDupDigitsAtMostN(number));
    }



    public int numDupDigitsAtMostN(int n) {
        String sn = String.valueOf(n);
        return n + 1 - f(0, sn, 0, true);
    }

    public int f(int mask, String sn, int i, boolean same) {
        if (i == sn.length()) {
            return 1;
        }
        int t = same ? sn.charAt(i) - '0' : 9, res = 0, c = Integer.bitCount(mask) + 1;
        for (int k = 0; k <= t; k++) {
            if ((mask & (1 << k)) != 0) {
                continue;
            }
            if (same && k == t) {
                res += f(mask | (1 << t), sn, i + 1, true);
            } else if (mask == 0 && k == 0) {
                res += f(0, sn, i + 1, false);
            } else {
                res += A(sn.length() - 1 - i, 10 - c);
            }
        }
        return res;
    }

    public int A(int x, int y) {
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= y--;
        }
        return res;
    }


    public int numDupDigitsAtMostN1(int n) {
        Integer[] count = {0};
        for (int i = 10; i <= n ; i++) {
            Map<Character,Integer> countMap = new HashMap<>();
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                countMap.put(c,countMap.getOrDefault(c,0) + 1);
            }
            countMap.forEach((k,v) -> {
                if(v > 1){
                    count[0]++;
                }
            });
        }
        return count[0];
    }
}
