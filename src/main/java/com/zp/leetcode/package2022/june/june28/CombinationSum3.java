package com.zp.leetcode.package2022.june.june28;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/28 10:59 上午
 * 组合总和III
 **/
public class CombinationSum3 {


    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        //System.out.println(combinationSum3.combinationSum3(3,7));
        //System.out.println(combinationSum3.combinationSum3(3,9));
        System.out.println(combinationSum3.combinationSum3(4,1));
    }

    public List<List<Integer>> combinationSum3(int k, int target) {

        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[array.length];
        backtrack(result,path,used,k,target,array,0);
        return result;
    }

    /**
     * 回溯
     * @param result
     * @param path
     * @param used
     * @param k
     * @param target
     * @param array
     * @param index
     */
    private void backtrack(List<List<Integer>> result, Stack<Integer> path, boolean[] used, int k, int target, int[] array, int index) {

        //终止条件
        int sum = pathSum(path);
        if(k == path.size() && sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < array.length; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && array[i] == array[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.push(array[i]);
            backtrack(result,path,used,k,target,array,i + 1);
            path.pop();
            used[i] = false;

        }
    }

    private int pathSum(Stack<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        return sum;
    }
}
