package com.zp.leetcode.package2022.may.may11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/5/10 9:18 上午
 * 汇总区间
 **/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        if(nums.length == 0){
            return strings;
        }
        if(nums.length == 1){
            strings.add(String.valueOf(nums[0]));
        }
        //指针
        int pointer = nums[0];
        String start = String.valueOf(pointer);
        String str = start;
        for (int i = 1; i < nums.length; i++) {
            pointer++;
            if(pointer != nums[i]){
                if(!str.equals(String.valueOf(nums[i - 1]))){
                    str += "->" + nums[i - 1];
                }
                strings.add(str.toString());
                pointer = nums[i];
                str = String.valueOf(nums[i]);

            }
            //最后
            if(i == nums.length - 1){
                if(!str.equals(String.valueOf(nums[i]))){
                    str += "->" + nums[i];
                }
                strings.add(str.toString());
            }

        }
        return strings;
    }



    public static void main(String[] args) {

        //int[] array = new int[]{0,2,3,4,6,8,9};
        //int[] array = new int[]{-1};
        int[] array = new int[]{1,3};
        //int[] array = new int[]{0,1,2,4,5,7};
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(array));

    }


}
