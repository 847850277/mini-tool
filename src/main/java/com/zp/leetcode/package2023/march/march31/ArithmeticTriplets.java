package com.zp.leetcode.package2023.march.march31;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/3/31 8:56 上午
 * 算术三元组的数目
 **/
public class ArithmeticTriplets {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,4,6,7,10};
        int num = 3;
        ArithmeticTriplets arithmeticTriplets = new ArithmeticTriplets();
        System.out.println(arithmeticTriplets.arithmeticTriplets(array,num));

    }


    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,num);
        }
        int sum = 0;
        for (int num : nums) {
            if(has(num,map,diff)){
                sum++;
            }
        }
        return sum;
    }

    private boolean has(int num, Map<Integer, Integer> map, int diff) {
        if(map.containsKey(num) && map.containsKey(num + diff) && map.containsKey(num + diff + diff)){
            return true;
        }
        return false;
    }

}
