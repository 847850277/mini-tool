package com.zp.leetcode.package2022.october.october27;

/**
 * @author zhengpeng
 * @date 2022/10/27 2:46 下午
 *  数组元素积的符号
 **/
public class ArraySign {

    public static void main(String[] args) {
        int[] array = new int[]{-1,-2,-3,-4,3,2,1};
        ArraySign arraySign = new ArraySign();
        System.out.println(arraySign.arraySign(array));
    }


    /**
     * 统计
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int lessThanZeroCount = 0;
        for (int num : nums) {
            if(num == 0){
                return 0;
            }
            if(num < 0){
                lessThanZeroCount++;
            }
        }
        if(lessThanZeroCount % 2 == 0){
            return 1;
        }else {
            return -1;
        }

    }
}
