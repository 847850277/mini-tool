package com.zp.leetcode.package_2022.june.june21;

/**
 * @author zhengpeng
 * @date 2022/6/20 10:28 上午
 * 乘积最大子数组
 **/
public class MaxProduct {

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
            if(previousNum > 0 && num <= 0){
                continuity = false;
                maxProduct = Math.max(maxProduct,currentProduct);
            }

            if(previousNum < 0 && num >= 0){
                continuity = false;
                maxProduct = Math.max(maxProduct,currentProduct);
            }

            if(previousNum == 0){
                maxProduct = Math.max(maxProduct,currentProduct);
                continuity = false;
            }

            if(continuity){
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
        int[] array = new int[]{-3,-1,-1};
        //int[] array = new int[]{-2,0,-1};
        System.out.println(maxProduct.maxProduct(array));

    }


}
