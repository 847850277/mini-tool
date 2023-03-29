package com.zp.leetcode.package2023.march.march29;

/**
 * @author zhengpeng
 * @date 2023/3/29 9:10 上午
 * 统计逆序对数量
 **/
public class CountInvert {

    public static void main(String[] args) {
        int[] array = new int[]{7,5,6,4};
        CountInvert countInvert = new CountInvert();
        System.out.println(countInvert.countInvert(array));
    }


    /**
     * 常规2次循环遍历求解
     * @param array
     * @return
     */
    public Integer countInvert(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    sum = sum + 1;
                }
            }
        }
        return sum;
    }
}
