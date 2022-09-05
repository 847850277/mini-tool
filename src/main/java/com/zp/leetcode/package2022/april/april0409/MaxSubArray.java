package com.zp.leetcode.package2022.april.april0409;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022-04-09 09:12
 * 最小子数组的和
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            result = Math.max(result,sum);
        }

        return result;

    }

    /*
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        // 设置起始位置
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            // 每次从起始位置i开始遍历寻找最大值
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                result = Math.max(count,result);
            }
        }
        return result;

    }

     */



    /**
     *
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        Integer maxValue = Integer.MIN_VALUE;
//        for (int i = 1; i <= nums.length; i++) {
//            maxValue = getMaxSubListSum(nums,i,maxValue);
//        }
//        return maxValue;
//    }

    /**
     * 取子数组中和的最大值与参数最大值对比，返回对比最大值
     * @param nums
     * @param i
     * @param maxValue
     * @return
     */
    private Integer getMaxSubListSum(int[] nums, int i, Integer maxValue) {

        int step = i;
        while (i <= nums.length){
            int startIndex =  i - step;
            int endIndex = startIndex + step;
            Integer sum = 0;
            for(int j = startIndex;j< endIndex;j++){
                sum += nums[j];
            }
            i++;
            maxValue = Math.max(sum,maxValue);
        }
        return maxValue;
    }

    /**
     * 数组的所以子数组
     * @param nums
     * @return
     */
    public List<Integer> allSubArray(int[] nums){
        List<Integer> result = new ArrayList<>();
        //个数循环，从最大开始，然后拆分到最小单位为1的个数
        for (int i = 1; i <= nums.length; i++) {
            //子素组的元素和
            result.addAll(getSubListSum(nums,i));
        }
        return result;
    }

    /**
     * 子数组的元素和
     * @param nums
     * @param i 子数组的元素个数
     * @return
     */
    private List<Integer> getSubListSum(int[] nums, int i) {
        List result = new ArrayList();
        int step = i;
        while (i <= nums.length){
            int startIndex =  i - step;
            int endIndex = startIndex + step;
            Integer sum = 0;
            for(int j = startIndex;j< endIndex;j++){
                sum += nums[j];
            }
            result.add(sum);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int[] array = new int[]{1,2,3,4,5};
        //int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //List<Integer> ints = maxSubArray.allSubArray(array);
        //System.out.println(ints);
        System.out.println(maxSubArray.maxSubArray(array));


    }

}
