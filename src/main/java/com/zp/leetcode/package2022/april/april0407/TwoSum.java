package com.zp.leetcode.package2022.april.april0407;

/**
 * @author zhengpeng
 * @date 2022-04-07 10:22
 * 两数之和
 **/
public class TwoSum {

    /**
     * 两数之和的索引,暴力枚举法优化
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] targetIndex = new int[2];
        int slowIndex = 0;
        //窗口
        while (slowIndex < nums.length -1){
            int fast = slowIndex + 1;
            while (fast < nums.length){
                int sumValue = nums[slowIndex] + nums[fast];
                if (sumValue != target){
                    fast++;
                }else {
                    targetIndex[0] = slowIndex;
                    targetIndex[1] = fast;
                    return targetIndex;
                }
            }
            slowIndex++;
        }
        return targetIndex;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        //int[] ints = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        //int[] ints = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        //int[] ints = twoSum.twoSum(new int[]{3, 3}, 6);
        int[] ints = twoSum.twoSum(new int[]{1,3,2,1,3}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
