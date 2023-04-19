package com.zp.leetcode.package2023.april.april19;

/**
 * @author zhengpeng
 * @date 2023/4/19 9:24 上午
 * 最大子数组问题
 **/
public class MaxSubArray {

    public static void main(String[] args) {

        //int[] array = new int[]{1,2,3,-3,5,2,0};
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(array));

    }


    public Integer maxSubArray(int[] array){
        int len = array.length;
        if(len == 0){
            return 0;
        }
        return maxSubArraySum(array, 0, len - 1);
    }

    private Integer maxSubArraySum(int[] array, int left, int right) {
        if(left == right){
            return array[left];
        }
        int mid = (left + right) / 2;

        return max3(maxSubArraySum(array,left,mid),
        maxSubArraySum(array,mid + 1,right),crossMaxSum(array,left,mid,right));
    }

    private Integer max3(Integer leftSum, Integer rightSum, Integer crossMaxSum) {
        return Math.max(Math.max(leftSum,rightSum),crossMaxSum);
    }


    private Integer crossMaxSum(int[] array, int left, int mid, int right) {
//        int leftSum = 0;
//        for (int i = left; i <= mid; i++) {
//            leftSum += array[i];
//        }
//        int rightSum = 0;
//        for (int i = mid + 1; i <= right ; i++) {
//            rightSum += array[i];
//        }
//        return leftSum + rightSum;
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


}
