package com.zp.leetcode.package2022.april.april0413;

/**
 * @author zhengpeng
 * @date 2022-04-12 09:11
 * 爬楼梯
 * 可拆解成 F（n） = F( n - 1) + F( n - 2) 且 F( 2 ) = 2, F( 1 ) = 1
 **/
public class ClimbStairs {


    /**
     * 原始递归
     * @param n
     * @return
     */
    /*
    public int climbStairs(int n) {
        // 已知道 F( 2 ) = 2, F( 1 ) = 1
        if(n == 1 || n == 2){
            return n;
        //递归
        }else if(n > 2){
            return climbStairs(n - 1) + climbStairs( n - 2 );
        }else {
            return 0;
        }

    }

     */

    /**
     * 变式基础上加
     *  基于  F（n） = F( n - 1) + F( n - 2)
     *  最小的原始可以设置为 F( 3 ) ,也就是 N 的最小值大于等于3为满足最小的条件
     *  比如 F( 4 ) = F( 3 ) + F ( 2 )
     *      F( 5 ) = F( 4 ) + F( 3 ) = F( 3 ) + F( 2 ) + F( 3 )
     *      那么就将上面的转变成 F( n ) = 所有都转换为最小的 xxx F( 3 ) + xxxF( 2 )
     *
     *      F5 = 2F3 + F2
     *      F6 = 2F4 + F3
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<= 2){
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i<= n; i++){
            // temp 即为 F（ 3 ）
            int temp = f1 + f2;
            // 这个变量则为 F ( 2 )
            f1 = f2;
            f2 = temp;
        }
        return f2;

    }



    public static void main(String[] args) {

        ClimbStairs climbStairs = new ClimbStairs();
        //System.out.println(climbStairs.climbStairs(2));
        //System.out.println(climbStairs.climbStairs(1));
        //System.out.println(climbStairs.climbStairs(3));
        //System.out.println(climbStairs.climbStairs(4));
        //System.out.println(climbStairs.climbStairs(5));
        System.out.println(climbStairs.climbStairs(45));



    }





}
