package com.zp.leetcode.package_2022.june.june06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhengpeng
 * @date 2022/6/4 9:35 下午
 * 子集，回溯算法
 *      回溯算法都可以抽象为树形结构，
 *  回溯法解决的都是在集合中递归查找子集，集合的大小决定了数的宽度，递归的深度，都构成树的深度
 *  
 **/
public class Subsets {

    List<List<Integer>> used = new ArrayList<>();

    /**
     * 所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0,nums,result,new ArrayList<>());
        return result;
    }

    /**
     * 包含重复元素的子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrackWithDup(0,result,nums,new ArrayList<>());
        return result;
    }

    private void backtrackWithDup(int i, List<List<Integer>> sets, int[] nums, List<Integer> temp) {
        ArrayList<Integer> list = new ArrayList<>(temp);
        if(!contains(used,list)){
            sets.add(list);
        }
        for(int j = i;j < nums.length;j++) {
            temp.add(nums[j]);
            backtrackWithDup(j + 1, sets, nums ,temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 包含
     * @param used
     * @param list
     * @return
     */
    private boolean contains(List<List<Integer>> used, ArrayList<Integer> list) {
        //排好序，扔进去
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (List<Integer> i : used) {
            if(i.size() != collect.size()) {
                continue;
            }
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < collect.size(); j++) {
                sb1.append(i.get(j));
                sb2.append(collect.get(j));
            }
            if(sb1.toString().equals(sb2.toString())){
                return true;
            }
        }
        used.add(collect);
        return false;
    }


    /**
     * 回溯
     * @param i
     * @param nums
     * @param result
     * @param temp
     */
    private void backtrack(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> temp) {
        //result.add()
        //当前层的集合
        result.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length;j++){
            temp.add(nums[j]);
            backtrack(j + 1,nums,result,temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        Subsets subsets = new Subsets();
        //nt[] array = new int[]{1,2,3};
        //int[] array = new int[]{1,2,2};
        int[] array = new int[]{4,4,4,1,4};
        System.out.println(subsets.subsetsWithDup(array));
        //testSet();

    }

    /**
     * 官方解答
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        //解题思路：全部解用遍历
        List<List<Integer>> result = new ArrayList();
        //包含重复数字要排序
        Arrays.sort(nums);
        dfs(result, nums, new ArrayList(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, int startIdx){
        //父节点路径保留
        result.add(new ArrayList(path));
        //如果超限则放弃
        if(startIdx == nums.length){
            return;
        }
        //递归
        for(int i = startIdx;  i < nums.length; i++){
            //排除重复元素
            if((i != startIdx && nums[i] == nums[i - 1])){
                continue;
            }
            path.add(nums[i]);
            dfs(result, nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 测试set
     */
    private static void testSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);

        Set<Integer> set3 = new HashSet<>();
        set3.add(2);
        set3.add(1);

        System.out.println(set1.equals(set3));

        List<Set> list = new ArrayList<>();
        andFilterRepeat(list,set1);
        andFilterRepeat(list,set2);
        andFilterRepeat(list,set3);

    }


    private static void andFilterRepeat(List<Set> list, Set<Integer> set1) {


    }


}
