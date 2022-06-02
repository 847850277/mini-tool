package com.zp.leetcode.package_2022.june.june02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/2 11:18 上午
 * 第三大的数
 **/
public class ThirdMax {


    public int thirdMax(int[] nums) {
        int[] threeArray = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        Map<Integer,Integer> keyMap = new HashMap<Integer,Integer>(nums.length * 2);
        for (int num : nums) {
            final int i = threeArray[0];
            if(num > i){
                threeArray[2] = threeArray[1];
                threeArray[1] = threeArray[0];
                threeArray[0] = num;
            }else if(num > threeArray[1] && num != threeArray[0]){
                threeArray[2] = threeArray[1];
                threeArray[1] = num;
            }else if(num > threeArray[2] && num != threeArray[1] && num != threeArray[0]){
                threeArray[2] = num;
            }
            keyMap.put(num,num);
        }
        if(threeArray[2] == Integer.MIN_VALUE){
            if(keyMap.keySet().size() <= 2){
                return threeArray[0];
            }else{
                return threeArray[2];
            }

        }else{
            return threeArray[2];
        }
    }


    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        //int[] array = new int[]{1,2,3,4,5};
        //int[] array = new int[]{2,2,3,1};
        int[] array = new int[]{1,2};
        //int[] array = new int[]{1,2,2,5,3,5};
        //int[] array = new int[]{1,2,-2147483648};
        System.out.println(thirdMax.thirdMax(array));
    }



}
