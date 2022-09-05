package com.zp.leetcode.package2022.may.may05;

/**
 * @author zhengpeng
 * @date 2022-05-05 09:08
 **/
public class HammingWeight {


    public int hammingWeight(int n) {

        long n1 = n;
        StringBuilder sb = new StringBuilder();
        //次方数
        int index = 0;
        int count = 0;
        while (n1 > 0){
            long a0 = n1 % 2;
            if(a0 / (Math.pow(2,index)) == 0){
                sb.append("0");
            }else {
                sb.append("1");
                count++;
            }
            n1 = (n1 - a0) / 2;
            index ++;
        }
        for (int i = index; i < 32; i++) {
            sb.append("0");
        }

        return count;
    }

    public int hammingWeight1(int n) {

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;

    }


    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
    }
}
