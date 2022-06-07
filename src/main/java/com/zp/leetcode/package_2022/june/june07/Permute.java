package com.zp.leetcode.package_2022.june.june07;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhengpeng
 * @date 2022/6/6 9:20 上午
 * 全排列
 **/
public class Permute {

    //使用记录变量
    boolean[] used ;
    //回溯路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(nums,used,result);
        return result;
    }

    /**
     * 
     * @param nums
     * @param used
     * @param result
     */
    private void backtracking(int[] nums, boolean[] used, List<List<Integer>> result) {

        //子节点，方法调用后出栈
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(used[i]){
                continue;
            }

            int num = nums[i];
            used[i] = true;
            path.add(num);

            backtracking(nums,used,result);

            used[i] = false;
            path.remove(path.size() - 1);

        }
    }


    public static void main(String[] args) {

        Permute permute = new Permute();
        int[] array = new int[]{1,2,3};
        System.out.println(permute.permute(array));

    }
}
