package com.zp.leetcode.package_2022.may.may19;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhengpeng
 * @date 2022/5/19 9:03 上午
 * 丑数
 **/
public class UglyNumber {

    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        //逐个除以 2或3或5
        Map<Boolean, Integer> booleanIntegerMap = canDevice(n);
        while(Objects.nonNull(booleanIntegerMap.get(true))){
            n = device(n,(booleanIntegerMap.get(true)));
            booleanIntegerMap = canDevice(n);
        }
        if(n == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param n
     * @param integer
     * @return
     */
    private int device(int n, Integer integer) {
        return n / integer;
    }


    private Map<Boolean, Integer> canDevice(int n) {
        HashMap<Boolean, Integer> booleanIntegerHashMap = new HashMap<Boolean, Integer>();
        final int i = n % 2;
        if(i == 0){
            booleanIntegerHashMap.put(true,2);
            return booleanIntegerHashMap;
        }
        final int j = n % 3;
        if(j == 0){
            booleanIntegerHashMap.put(true, 3);
            return booleanIntegerHashMap;
        }
        final int k = n % 5;
        if(k == 0){
            booleanIntegerHashMap.put(true,5);
            return booleanIntegerHashMap;
        }

        return booleanIntegerHashMap;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        //System.out.println(uglyNumber.isUgly(2));
        System.out.println(uglyNumber.isUgly(0));
        //System.out.println(uglyNumber.isUgly(6));


    }

}
