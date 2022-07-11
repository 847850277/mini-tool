package com.zp.leetcode.package_2022.july.july11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/10 9:48 上午
 * 分割等和子集
 **/
public class CanPartition {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        Map<Integer,Integer> keyMap = new HashMap<Integer,Integer>();
        for (int num : nums) {
            sum += num;
            Integer orDefault = keyMap.getOrDefault(num, 0);
            orDefault = orDefault + 1;
            keyMap.put(num,orDefault);
        }
        if(sum % 2 != 0){
            return false;
        }
        int divide = sum / 2;
        Integer key = divide;
        int theRemaining = divide;

        if(keyMap.keySet().size() == 1){
            return true;
        }

        for (Map.Entry<Integer, Integer> entry : keyMap.entrySet()) {
            final int i = entry.getKey() * entry.getValue();
            if(i == divide){
                key = entry.getKey();
            }
        }
        if(keyMap.containsKey(key)){
            keyMap.remove(key);
            for (Map.Entry<Integer, Integer> entry : keyMap.entrySet()) {
                theRemaining = theRemaining - entry.getKey() * entry.getValue();
            }
        }else{
            for (int num : nums) {
                divide = divide - num;
                if(divide == 0){
                    return true;
                }
            }
        }

        //再次遍历源数组
        int temp = divide;




        return theRemaining == 0;
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        //int[] array = new int[]{3,3,3,4,5};
        //int[] array = new int[]{1,5,11,5};
        //int[] array = new int[]{1,2,3,5};
        //int[] array = new int[]{1,1};
        int[] array = new int[]{2,2,1,1};
        //int[] array = new int[]{1,2,5};
        System.out.println(canPartition.canPartition(array));
    }

}
