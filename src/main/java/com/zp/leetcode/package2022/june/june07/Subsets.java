package com.zp.leetcode.package2022.june.june07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/7 9:05 上午
 * 集合的所有子集
 **/
public class Subsets {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0,result,nums,new ArrayList<Integer>());
        return result;
    }

    /**
     * 回溯
     * @param i
     * @param result
     * @param nums
     * @param temp
     */
    private void backtrack(int i, List<List<Integer>> result, int[] nums, ArrayList<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            backtrack(j + 1,result,nums,temp);
            //回溯
            temp.remove(temp.size() - 1);
        }
    }

    private void backtrack(int i, List<List<String>> result, char[] nums, ArrayList<Character> temp) {
        result.add(new ArrayList(temp));
        for (int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            backtrack(j + 1,result,nums,temp);
            //回溯
            temp.remove(temp.size() - 1);
        }
    }


    public List<List<String>> subsets(char[] chars) {
        List<List<String>> result = new ArrayList<List<String>>();
        backtrack(0,result,chars,new ArrayList<Character>());
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        final List<List<Integer>> subsets1 = subsets.subsets(array);

        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        char[] chars = s.toCharArray();
        final List<List<String>> subsets2 = subsets.subsets(chars);

        System.out.println(subsets2);

    }
}
