package com.zp.leetcode.package_2022.may.may06;

/**
 * @author zhengpeng
 * @date 2022-05-06 08:54
 * 快乐数
 **/
public class HappyNumber {


    /**
     * 是否是快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n){
        while (n > 0){
            if (n == 1 || n == 7){
                return true;
            }else if(n < 10) {
                return false;
            }
            n = iterGetSum(n);
        }
        return false;
    }

    /**
     * 递归拆分求和
     * @param n
     * @return
     */
    private int iterGetSum(int n) {
        int sum = 0;
        int digitNum = getDigitNum(n);
        String s = String.valueOf(n);
        for (int i = 0; i < digitNum; i++) {
            final char c = s.charAt(i);
            final Integer integer = Integer.parseInt(String.valueOf(c));
            sum += Math.pow(integer,2);
        }
        return sum;

    }

    /**
     * 获取位数
     * @param n
     * @return
     */
    private int getDigitNum(int n) {
        int digitNum  = 0;
        double pow = Math.pow(10, digitNum);
        while (pow < n){
            digitNum++;
            pow = Math.pow(10, digitNum);
        }
        //边界
        if(pow == n){
            return ++digitNum;
        }
        return digitNum--;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        //System.out.println(happyNumber.isHappy(19));
        //System.out.println(happyNumber.isHappy(19));
        //System.out.println(happyNumber.isHappy(100));
        //System.out.println(happyNumber.isHappy(2));
        System.out.println(happyNumber.isHappy(1));
        System.out.println(happyNumber.isHappy(7));
        System.out.println(happyNumber.isHappy(8));
        //System.out.println(happyNumber.getDigitNum(109));
        //System.out.println(109 % 10);
        //System.out.println(1009 % 10);



    }
}

