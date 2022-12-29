package com.zp.leetcode.package2022.december.december29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhengpeng
 * @date 2022/12/29 10:15 上午
 * 至少在两个数组中出现的值
 **/
public class TwoOutOfThree {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,1,3,2};
        int[] array2 = new int[]{2,3};
        int[] array3 = new int[]{3};
        TwoOutOfThree twoOutOfThree = new TwoOutOfThree();
        System.out.println(twoOutOfThree.twoOutOfThree(array1,array2,array3));

    }


    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map1.put(i,1);
            map.put(i,1);
        }
        for (int i : nums2) {
            if(map1.containsKey(i)){
                map.put(i,2);
            }
            map2.put(i,1);
        }
        for (int i : nums3) {
            if(map1.containsKey(i)){
                map.put(i,3);
            }
            if(map2.containsKey(i)){
                map.put(i,2);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        map.forEach((k,v) ->{
            if(v >= 2){
                res.add(k);
            }
        });
        return res;
    }
}
