package com.zp.leetcode.package_2022.june.june07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/7 10:29 上午
 * 组合总和
 **/
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //空结果集合
        if(candidates[0] > target){
            return new ArrayList<>();
        }





        return null;
    }
}
