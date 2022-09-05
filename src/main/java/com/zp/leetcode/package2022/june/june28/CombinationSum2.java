package com.zp.leetcode.package2022.june.june28;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/28 9:46 上午
 * 组合总和II
 **/
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] array = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2.combinationSum24(array,target));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,path,candidates,target,0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, Stack<Integer> path, int[] candidates, int target, int index) {

        int sum = sumPath(path);
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < candidates.length;i++){
            path.push(candidates[i]);
            backtrack(result,path,candidates, target,i + 1);
            path.pop();
        }
    }


    public List<List<Integer>> combinationSum24(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<>();
        backTracking(result,path,candidates, target, 0, flag);
        return result;
    }

    public void backTracking(List<List<Integer>> result,Stack<Integer> path,int[] arr, int target, int index, boolean[] flag) {
        int sum = sumPath(path);
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            path.push(arr[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backTracking(result,path,arr, target, i + 1, flag);
            flag[i] = false;
            path.pop();
        }
    }



    private int sumPath(Stack<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        return sum;
    }

}
