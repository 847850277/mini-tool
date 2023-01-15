package com.zp.leetcode.package2023.january.january15;

/**
 * @author zhengpeng
 * @date 2023/1/15 9:44 上午
 **/
public class MinMaxGame {

    public static void main(String[] args) {

        int[] array = new int[]{1,3,5,2,4,8,2,2};
        MinMaxGame min = new MinMaxGame();
        System.out.println(min.minMaxGame(array));

    }

    public int minMaxGame(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int[] newArray = new int[len/2];
        //赋值
        for (int i = 0; i < newArray.length; i++) {
            //偶数下标
            if (i % 2 == 0) {
                newArray[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            //奇数下标
            } else {
                newArray[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newArray);
    }
}
