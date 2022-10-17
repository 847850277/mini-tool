package com.zp.leetcode.package2022.october.october17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/10/17 8:59 上午
 * 水果成篮
 **/
public class TotalFruit {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        //Integer remove = list.remove(0);
        //System.out.println(remove);

        //int[] array = new int[]{1,2,1};
        //int[] array = new int[]{1,2,1};
        //int[] array = new int[]{0,1,2,2};
        //int[] array = new int[]{1,2,3,2,2};
        int[] array = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        TotalFruit fruit = new TotalFruit();
        System.out.println(fruit.totalFruit(array));

    }

    /**
     * 水果成篮子
     *
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;
        int len = fruits.length;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int right = 0; right < len; right++) {
            int val = fruits[right];
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
            //滑动窗口
            while (countMap.size() > 2) {
                int fruit = fruits[left];
                countMap.put(fruit, countMap.get(fruit) - 1);
                if (countMap.get(fruit) == 0) {
                    countMap.remove(fruit);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param fruits
     * @return
     */
    public int totalFruit1(int[] fruits) {
        int max = 0;
        List<Integer> slideWindow = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < fruits.length; i++) {


            //窗口滑动
            if (slideWindow.size() > 2) {
                Integer remove = slideWindow.remove(0);
                if (map.containsKey(remove)) {
                    map.remove(remove);
                }
            }
        }
        return max;
    }
}
