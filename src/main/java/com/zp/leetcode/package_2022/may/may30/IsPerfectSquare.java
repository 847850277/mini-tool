package com.zp.leetcode.package_2022.may.may30;

/**
 * @author zhengpeng
 * @date 2022/5/29 8:31 下午
 * 有效的完全平方数
 **/
public class IsPerfectSquare {

    /**
     * 遍历循环，会超过时间限制
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            int pow = i * i;
            if(pow == num ){
                return true;
            }
            if(pow > num){
                return false;
            }
        }
        return false;
    }

    /**
     * 二分查找，加快进程
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int start = 0;
        int end = num;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            long i = (long)mid * mid;
            if(i == num){
                return true;
            }else if( i > num){
                end = mid - 1;
            }else if(i < num){
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare3(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {

        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        //System.out.println(isPerfectSquare.isPerfectSquare2(14));
        //System.out.println(isPerfectSquare.isPerfectSquare2(16));
        //System.out.println(isPerfectSquare.isPerfectSquare2(1));
        //System.out.println(isPerfectSquare.isPerfectSquare2(14));
        System.out.println(isPerfectSquare.isPerfectSquare2(2147483647));
        System.out.println(isPerfectSquare.isPerfectSquare3(2147483647));
        //System.out.println(isPerfectSquare.isPerfectSquare2(9));
    }
}
