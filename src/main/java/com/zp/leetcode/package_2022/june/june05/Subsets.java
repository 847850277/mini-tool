package com.zp.leetcode.package_2022.june.june05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/4 9:35 下午
 * 子集，回溯算法
 *      回溯算法都可以抽象为树形结构，
 *  回溯法解决的都是在集合中递归查找子集，集合的大小决定了数的宽度，递归的深度，都构成树的深度
 *  
 **/
public class Subsets {

    /**
     * 所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {

        Subsets subsets = new Subsets();
        int[] array = new int[]{1,2,3};
        System.out.println(subsets.subsets(array));

    }


}
