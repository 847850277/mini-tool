package com.zp.leetcode.package2022.october.october18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/10/18 8:58 上午
 * 水果成篮子
 **/
public class TotalFruit {

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,2,1};
        int[] array = new int[]{1,2,3,1,1,3};
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(array));
    }


    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int ans = 0, left = 0;
        for (int right = 0; right < len; right++) {
            int val = fruits[right];
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
            // 窗口滑动
            while (countMap.size() > 2) {
                int leftVal = fruits[left];
                countMap.put(leftVal, countMap.get(leftVal) - 1);
                if (countMap.get(leftVal) == 0) {
                    countMap.remove(leftVal);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


}
