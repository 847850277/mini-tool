package com.zp.leetcode.package2023.may.may29;

/**
 * @author zhengpeng
 * @date 2023/5/29 1:43 下午
 * 可被3整除的偶数的平均数
 **/
public class AverageValue {

    public static void main(String[] args) {
        System.out.println(19/2);
    }


    public int averageValue(int[] nums) {
        int sum = 0,count = 0;
        for (int i : nums) {
            if(i % 6 == 0 ){
                sum += i;
                count++;
            }
        }
        return sum == 0 ?  0 :  sum / count;
    }

}
