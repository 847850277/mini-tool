package com.zp.leetcode.package2023.april.april21;

/**
 * @author zhengpeng
 * @date 2023/4/21 9:55 上午
 * 最小偶数倍
 **/
public class SmallestEvenMultiple {

    public static void main(String[] args) {

        SmallestEvenMultiple smallestEvenMultiple = new SmallestEvenMultiple();
        //int n = 5;
        int n = 6;
        System.out.println(smallestEvenMultiple.smallestEvenMultiple(n));

    }


    public int smallestEvenMultiple(int n) {
        if(n % 2 == 0){
            return n;
        }
        return  n * 2;
    }

}
