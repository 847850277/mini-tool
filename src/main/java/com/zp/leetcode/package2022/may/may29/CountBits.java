package com.zp.leetcode.package2022.may.may29;

/**
 * @author zhengpeng
 * @date 2022/5/26 10:33 上午
 * 比特位计数
 **/
public class CountBits {

    public int[] countBits(int n) {
        int[] array = new int[n + 1];
        int powerIndex = 0;
        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            final double pow = Math.pow(2, powerIndex);
            if(i > pow){
                powerIndex++;
            }
            int pre = array[(int) Math.pow(2, powerIndex - 1)];
            array[i] = pre + powerIndex;
        }
        return array;
    }

    public int[] countBits1(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            final String s = Integer.toBinaryString(i);
            final int length = s.length();
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if(s.charAt(j) == '1'){
                    sum++;
                }
            }
            array[i] = sum;
        }
        return array;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        //final int[] ints = countBits.countBits(5);
        final int[] ints = countBits.countBits1(5);
        for (int anInt : ints) {
            System.out.printf(anInt + ",");
        }


    }
}
