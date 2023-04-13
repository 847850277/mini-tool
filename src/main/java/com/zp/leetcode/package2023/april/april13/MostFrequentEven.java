package com.zp.leetcode.package2023.april.april13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/4/13 9:39 上午
 * 出现最频繁的偶数元素
 **/
public class MostFrequentEven {

    public static void main(String[] args) {

        int[] array = new int[]{0,1,2,2,4,4,1};
        MostFrequentEven mostFrequentEven = new MostFrequentEven();
        System.out.println(mostFrequentEven.mostFrequentEven(array));

    }

    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        int ans = Integer.MAX_VALUE;
        int maxNum = 0;
        for (int num : nums) {
            if(num % 2 == 0){
                int number = countMap.getOrDefault(num, 0) + 1;
                if(number > maxNum){
                    ans = num;
                }else if(number == maxNum){
                    ans = Math.min(ans,num);
                }
                maxNum = Math.max(maxNum,number);
                countMap.put(num,number);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
