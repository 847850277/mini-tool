package com.zp.leetcode.package2023.march.march24;

/**
 * @author zhengpeng
 * @date 2023/3/24 4:29 下午
 **/
public class MaxSubArray {


    public static void main(String[] args) {

        int[] array = new int[]{-1,-3,3,5,-4,3,2,-2,3,6};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray_0(array));

    }

    /**
     * 三成循环最大子数组
     * @param array
     * @return
     */
    public Integer maxSubArray_0(int[] array){

        int n = array.length;
        int max = Integer.MIN_VALUE;
        //起点
        for (int left = 0; left < n; left++) {
            //终点
            for (int right = left; right < n; right++) {
                int sum  = 0;
                //区间求和
                for (int k = left; k <= right; k++) {
                    sum += array[k];
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    /**
     * 两层循环
     * @param array
     * @return
     */
    public Integer maxSubArray_1(int[] array){
        int n = array.length;
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int sum = 0;
            for (int right = left; right < n; right++) {
                sum += array[right];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
