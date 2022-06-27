package com.zp.leetcode.package_2022.june.june27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/27 9:14 上午
 * 整数转罗马数字
 **/
public class IntToRoman {
    Map<Integer,String> map = new HashMap<Integer,String>(){
        {
            put(1,"I");
            put(4,"IV");
            put(5,"V");
            put(9,"IX");
            put(10,"X");
            put(40,"XL");
            put(50,"L");
            put(90,"XC");
            put(100,"C");
            put(400,"CD");
            put(500,"D");
            put(900,"CM");
            put(1000,"M");
        }
    };

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        //System.out.println(intToRoman.intToRoman(4));
        //System.out.println(intToRoman.intToRoman(6));
        //System.out.println(intToRoman.intToRoman(3));
        //System.out.println(intToRoman.intToRoman(9));
        //System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(1994));
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if(num >= 1000){
                num = num - 1000;
                sb.append(map.get(1000));
            }else if(num >= 900){
                num = num - 900;
                sb.append(map.get(900));
            }else if(num >= 500){
                num = num - 500;
                sb.append(map.get(500));
            }else if(num >= 400){
                num = num - 400;
                sb.append(map.get(400));
            }else if(num >= 100){
                num = num - 100;
                sb.append(map.get(100));
            }else if(num >= 90){
                num = num - 90;
                sb.append(map.get(90));
            }else  if(num >= 50){
                num = num - 50;
                sb.append(map.get(50));
            }else if(num >= 40){
                num = num - 40;
                sb.append(map.get(40));
            }else if(num >= 10){
                num = num - 10;
                sb.append(map.get(10));
            }else if(num >= 9){
                num = num - 9;
                sb.append(map.get(9));
            }else if(num >= 5){
                num = num - 5;
                sb.append(map.get(5));
            }else if(num >= 4){
                num = num - 4;
                sb.append(map.get(4));
            }else if(num >= 1){
                num = num - 1;
                sb.append(map.get(1));
            }
        }
        return  sb.toString();
    }

}
