package com.zp.leetcode.package2022.june.june13;

/**
 * @author zhengpeng
 * @date 2022/6/10 10:55 上午
 *
 **/
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int maxSize = Math.max(length1, length2);
        if(num1.length() < maxSize){
            int diff = maxSize - num1.length();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                temp.append("0");
            }
            num1 = temp.toString() + num1;
        }
        if(num2.length() < maxSize){
            int diff = maxSize - num2.length();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                temp.append("0");
            }
            num2 = temp.toString() + num2;;
        }

        StringBuilder sb = new StringBuilder();
        boolean needCarry = false;
        for (int i = maxSize - 1; i >= 0; i--) {
            final char charAt1 = num1.charAt(i);
            final char charAt2 = num2.charAt(i);
            final Integer i1 = Integer.parseInt(String.valueOf(charAt1));
            final Integer i2 = Integer.parseInt(String.valueOf(charAt2));
            final int i3 = i1 + i2;
            String result = "";
            if((i3 == 9) && needCarry){
                needCarry = true;
                result = "0";
            }else if(i3 > 9){
                if(needCarry){
                    needCarry = true;
                    final int i4 = i3 - 10 + 1;
                    result = String.valueOf(i4);
                }else{
                    needCarry = true;
                    final int i4 = i3 - 10;
                    result = String.valueOf(i4);
                }

            }else if(needCarry){
                needCarry = false;
                final int i4 = i3  + 1;
                result = String.valueOf(i4);
            }else{
                needCarry = false;
                result = String.valueOf(i3);
            }
            sb.append(result);
        }
        if(needCarry){
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();

        //System.out.println(addStrings.addStrings("123","11"));
        //System.out.println(addStrings.addStrings("456","77"));
        //System.out.println(addStrings.addStrings("6913259244","71103343"));
        System.out.println(addStrings.addStrings("401716832807512840963","167141802233061013023557397451289113296441069"));
        //System.out.println(addStrings.addStrings("1","9"));
        //System.out.println(addStrings.addStrings("0","0"));
        //System.out.println(('1' + '1'));
        //System.out.println('1');

        //"401716832807512840963"
        //"167141802233061013023557397451289113296441069"

        //System.out.println(addStrings.addStrings("123","11"));
    }
}
