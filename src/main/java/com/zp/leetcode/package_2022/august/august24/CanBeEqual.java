package com.zp.leetcode.package_2022.august.august24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/8/24 3:19 下午
 * 翻转子数组使两个数组相等
 **/
public class CanBeEqual {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 1, 1, 1, 1};
        int[] arr2 = new int[] {1, 1, 1, 1, 1};
        CanBeEqual canBeEqual = new CanBeEqual();
        System.out.println(canBeEqual.canBeEqual(arr1, arr2));
    }


    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : target) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for (int i : arr) {
            if(map.containsKey(i)){
                int num = map.get(i);
                num--;
                map.put(i,num);
                if(num == 0) {
                    map.remove(i);
                }
            }
        }
        return map.size() == 0;
    }
}
