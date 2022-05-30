package com.zp.leetcode.package_2022.may.may30;

/**
 * @author zhengpeng
 * @date 2022/5/30 10:19 上午
 * 猜数字大小
 **/
public class GuessNumber extends GuessGame {

    /**
     * 猜数字大小
     * @param n
     * @return
     */
    public int guessNumber(int n) {

        int left = 0;
        int right = n;
        while(left <= right){
            int mid = ( right - left ) / 2 + left ;
            if(guess(mid) > 0){
                left = left + 1;
            }else if(guess(mid) < 0){
                right = right - 1;
            }else{
                return mid;
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }

}

class GuessGame{


    /**
     * 内置猜数方法
     * @param num
     * @return
     */
    int guess(int num){

        return 0;
    }
}
