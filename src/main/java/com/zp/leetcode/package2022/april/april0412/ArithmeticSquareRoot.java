package com.zp.leetcode.package2022.april.april0412;

/**
 * @author zhengpeng
 * @date 2022-04-11 09:22
 * 算术平方根
 **/
public class ArithmeticSquareRoot {


    /**
     * 二分查找法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //特殊 0 和 1 的平方根
        if(x == 0 || x == 1){
            return x;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            System.out.println(String.format("当前的值{%s},{%s},{%s}",left,mid,right));
            //进入下次查找的条件
            if(mid > x / mid){
                //下一轮搜索区间
                right = mid - 1;
            }else {
                //下一轮搜索区间
                left = mid;
            }
            System.out.println(String.format("后的的值{%s},{%s},{%s}",left,mid,right));
        }
        return left;
    }


    public static void main(String[] args) {
        ArithmeticSquareRoot squareRoot = new ArithmeticSquareRoot();
        //System.out.println(squareRoot.mySqrt(8));
        //System.out.println(squareRoot.mySqrt(100));
        //System.out.println(squareRoot.mySqrt(99));
        System.out.println(squareRoot.mySqrt(1024));


    }

}
