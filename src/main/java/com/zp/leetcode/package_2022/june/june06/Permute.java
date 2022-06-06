package com.zp.leetcode.package_2022.june.june06;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhengpeng
 * @date 2022/6/6 9:20 上午
 * 全排列
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            backtrack(result,i,nums);
        }
        return result;
    }

    /**
     * 回溯
     * @param result 装结果集
     * @param i 索引
     * @param nums 原数组
     */
    private void backtrack(List<List<Integer>> result, int i,int[] nums) {







    }

    public static void main(String[] args) {

        Permute permute = new Permute();
        int[] array = new int[]{1,2,3};
        System.out.println(permute.permute(array));

    }
}
