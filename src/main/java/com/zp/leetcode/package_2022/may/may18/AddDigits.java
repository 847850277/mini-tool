package com.zp.leetcode.package_2022.may.may18;

/**
 * @author zhengpeng
 * @date 2022/5/17 3:49 下午
 * 各位数相加
 **/
public class AddDigits {


    /**
     * 10进制数字的长度
     * @param num
     * @return
     */
    public int numberLength(int num){
        String numStr = String.valueOf(num);
        return numStr.length();
    }

    public int addDigits(int num) {
          int length = numberLength(num);
          if (length > 1){
              //求和
              int sum = 0;
              String str = String.valueOf(num);
              for (int i = 0; i < length; i++) {
                  sum += Integer.parseInt(String.valueOf(str.charAt(i)));
              }
              return addDigits(sum);
          }else{
              return num;
          }

    }


    public static void main(String[] args) {

        AddDigits addDigits = new AddDigits();
//        System.out.println(addDigits.numberLength(123));
//        System.out.println(addDigits.numberLength(99));
//        System.out.println(addDigits.numberLength(1));
//        System.out.println(addDigits.numberLength(1000));

        System.out.println(addDigits.addDigits(12));
        System.out.println(addDigits.addDigits(38));


    }

}
