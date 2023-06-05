package com.zp.leetcode.package2023.june.june05;


/**
 * @author zhengpeng
 * @date 2023/6/5 09:33
 * 对数组执行操作
 **/
public class ApplyOperations {

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,2,1,1,0};
        //int[] array = new int[]{0,1};
        int[] array = new int[]{847,847,0,0,0,399,416,416,879,879,206,206,206,272};
        ApplyOperations applyOperations = new ApplyOperations();
        int[] ints = applyOperations.applyOperations(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }




    public int[] applyOperations(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]){
                //跳过
            }else {
               nums[i] = nums[i] * 2;
               nums[i + 1] = 0;
            }
        }
        int[] ans = new int[nums.length];
        int i = 0;
        for (int x : nums) {
            if (x > 0) {
                ans[i++] = x;
            }
        }
        return ans;
    }

}
