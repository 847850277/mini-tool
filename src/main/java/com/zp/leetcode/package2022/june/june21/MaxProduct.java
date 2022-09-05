package com.zp.leetcode.package2022.june.june21;

/**
 * @author zhengpeng
 * @date 2022/6/20 10:28 上午
 * 乘积最大子数组
 * 思路： 求最大值，可以看成求被0拆分的各个子数组的最大值。
 *
 * 当一个数组中没有0存在，则分为两种情况：
 *
 * 1.负数为偶数个，则整个数组的各个值相乘为最大值；
 *
 * 2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
 **/
public class MaxProduct {


    public int maxProduct1(int[] nums) {
        int a = 1;
        int max = nums[0];

        for (int num : nums) {
            a = a * num;
            if (max < a) max = a;
            if (num == 0) a = 1;

        }
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            a = a * nums[i];
            if (max < a) max = a;
            if (nums[i] == 0) a = 1;
        }
        return max;
    }




    public int maxProduct(int[] nums) {

        int maxProduct = Integer.MIN_VALUE;
        //上一个数
        int previousNum = nums[0];
        int currentProduct = nums[0];
        //连续
        boolean continuity = true;
        int length = nums.length;

        if(length == 1){
            return currentProduct;
        }

        for (int i = 1; i < length; i++) {
            final int num = nums[i];
//            if(previousNum > 0 && num <= 0){
//                continuity = false;
//                maxProduct = Math.max(maxProduct,currentProduct);
//            }
//
//            if(previousNum < 0 && num >= 0){
//                continuity = false;
//                maxProduct = Math.max(maxProduct,currentProduct);
//            }

            if(previousNum == 0){
                maxProduct = Math.max(maxProduct,currentProduct);
                continuity = false;
            }

            if(continuity){
                maxProduct = Math.max(maxProduct,num);
                currentProduct = currentProduct * num;
                maxProduct = Math.max(maxProduct,currentProduct);
            }else{
                //maxProduct = Math.max(maxProduct,currentProduct);
                currentProduct = num;
                continuity = true;
                previousNum = num;
            }
        }

        return Math.max(maxProduct,currentProduct);
    }




    public static void main(String[] args) {

        MaxProduct maxProduct = new MaxProduct();
        //int[] array = new int[]{2,3,-2,4};
        //int[] array = new int[]{-3,-1,-1};
        //int[] array = new int[]{-2,3,-4};
        int[] array = new int[]{3,-1,4};
        //int[] array = new int[]{-2,0,-1};
        System.out.println(maxProduct.maxProduct(array));

    }


}
