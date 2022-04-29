package com.zp.leetcode.package_2022.april.april0429;

/**
 * @author zhengpeng
 * @date 2022-04-29 09:09
 * 颠倒二进制位
 **/
public class ReverseBits {


    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    /**
     * 转换为32位二进制
     * @param n
     * @return
     */
    public String to32Binary(int n){

        StringBuilder sb = new StringBuilder("00000000000000000000000000000000");
        int index = 0;
        //System.out.println(n / 2);
        for (int i = 0; i< 32 ; i++){
            //偶数
            if(n % 2 == 0){


            //奇数
            }else {

            }
        }
        return "";
    }

    /**
     * 常规思路
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        //转换为32位
        //反转
        //然后再把32位转换位整数返回
        int ans = 0;
        for (int i = 0; i < 32; i++) {



        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();

        //System.out.println(reverseBits.reverseBits(00000010100101000001111010011100));
        //System.out.println(reverseBits.reverseBits(43261596));
        System.out.println(reverseBits.to32Binary(43261596));

    }
}
