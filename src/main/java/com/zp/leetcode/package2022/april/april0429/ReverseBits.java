package com.zp.leetcode.package2022.april.april0429;

/**
 * @author zhengpeng
 * @date 2022-04-29 09:09
 * 颠倒二进制位
 **/
public class ReverseBits {


    public long binaryToLong(String s){

        int size = s.length();
        long sum = 0L;
        for (int i = 0; i < size;i++) {
           if(s.charAt(size - i - 1) == '1'){
               sum += Math.pow(2,i);
           }
        }
        return sum;
    }

    /**
     * 转换为32位二进制
     * @param n
     * @return
     */
    @SuppressWarnings("Duplicates")
    public String to32Binary(long n){

        StringBuilder sb = new StringBuilder();
        //次方数
        int index = 0;
        while (n > 0){
            long a0 = n % 2;
            if(a0 / (Math.pow(2,index)) == 0){
                sb.append("0");
            }else {
                sb.append("1");
            }
            n = (n - a0) / 2;
            index ++;
        }
        for (int i = index; i < 32; i++) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }

    /**
     * 常规思路
     * @param n
     * @return
     */
    @SuppressWarnings("Duplicates")
    public long reverseBits(long n) {
        StringBuilder sb = new StringBuilder();
        //次方数
        int index = 0;
        while (n > 0){
            long a0 = (n % 2);
            if(a0 / (Math.pow(2,index)) == 0){
                sb.append("0");
            }else {
                sb.append("1");
            }
            n = (n - a0) / 2;
            index ++;
        }
        for (int i = index; i < 32; i++) {
            sb.append("0");
        }

        // 求和
        StringBuilder newB = sb.reverse();
        long sum = 0L;
        for (int j = 0; j < 32; j++) {
            final char c = newB.charAt(j);
            if(c == '1'){
                sum += Math.pow(2,j);
            }
        }
        return sum;
    }

    public int reverseBits2(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1) {
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        //System.out.println(reverseBits.reverseBits(43261596));
        //System.out.println(reverseBits.reverseBits(4294967293L));
        //System.out.println(reverseBits.reverseBits(3221225471));
        //System.out.println(reverseBits.reverseBits2(3221225471));
        System.out.println(reverseBits.reverseBits(4294967293L));
        //System.out.println(reverseBits.binaryToLong("11111111111111111111111111111101"));
        System.out.println(reverseBits.to32Binary(4294967293L));
        //System.out.println(reverseBits.binaryToLong("00111111111111111111111111111111"));
        //System.out.println(reverseBits.to32Binary(20));
        //System.out.println(reverseBits.to32Binary(3));
        //System.out.println(reverseBits.to32Binary(100));
        //System.out.println(reverseBits.to32Binary(4));

    }
}
