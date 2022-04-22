package com.zp.leetcode.package_2022.april.april0422;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-04-22 09:21
 * 只出现一次的数字
 **/
public class SingleNumber {

    /**
     * 已知条件，其余每个元素出现两次，有且仅有一个元素出现一次
     * 利用map，如果有key，就移除，如果没有就put，最后返回map的存在的唯一key
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> maps = new HashMap(nums.length);
        for (int num : nums) {
            if(maps.containsKey(num)){
                maps.remove(num);
            }else {
                maps.put(num,num);
            }
        }
        //返回第一条
        return maps.keySet().stream().findFirst().get();
    }


    public static void main(String[] args) {
        int[] array = new int[]{2,2,1};
        final SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(array));
    }

}
