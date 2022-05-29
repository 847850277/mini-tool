package com.zp.leetcode.package_2022.may.may29;

/**
 * @author zhengpeng
 * @date 2022/5/29 8:31 下午
 * 有效的完全平方数
 **/
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= 32; i++) {
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
}
