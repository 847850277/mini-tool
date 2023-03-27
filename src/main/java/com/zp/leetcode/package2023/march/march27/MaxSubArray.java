package com.zp.leetcode.package2023.march.march27;

/**
 * @author zhengpeng
 * @date 2023/3/27 2:38 下午
 * 最大子数组和
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{1,-2,4,5,-2,8,3,-2,6,3,7,-1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray_2(array));
    }

    /**
     * 分治法求最大子数组和
     * @param array
     * @return
     */
    public Integer maxSubArray_2(int[] array){
        int len = array.length;
        if(len == 0){
            return 0;
        }
        return maxSubArraySum(array, 0, len - 1);
    }

    /**
     * 分、递归求解
     * @param array
     * @param left
     * @param right
     * @return
     */
    private Integer maxSubArraySum(int[] array, int left, int right) {
        if(left == right){
            return array[left];
        }
        int mid = left + (right - left) / 2;
        return max3(maxSubArraySum(array,left,mid),
                maxSubArraySum(array,mid + 1,right),
                maxCrossingSum(array,left,mid,right));
    }

    /**
     * 合并求解
     * @param array
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int maxCrossingSum(int[] array, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += array[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public int max3(int num1,int num2,int num3){
        return Math.max(num1,Math.max(num2,num3));
    }

}
