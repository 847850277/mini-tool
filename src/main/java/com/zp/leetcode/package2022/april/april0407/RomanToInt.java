package com.zp.leetcode.package2022.april.april0407;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-04-07 09:30
 * 罗马数字转换为数字
 **/
public class RomanToInt {



    public static class Solution{

        private Map<Character, Integer> convertMap = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};


        /**
         * 逐位累加求和
         * @param s
         * @return
         */
//        public int romanToInt(String s){
//            //转换成字符数组
//            char[] chars = s.toCharArray();
//            int result = 0;
//            for (char c : chars) {
//                result += convertMap.get(c);
//            }
//            return result;
//        }


        /**
         *
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            char[] chars = s.toCharArray();
            int result = 0;
            for (int i = 0; i < chars.length; i++) {
                int nextIndex = i + 1;
                //判断防止最后一位溢出
                if(nextIndex < chars.length){
                    Integer charValue = convertMap.get(chars[i]);
                    Integer nextCharValue = convertMap.get(chars[nextIndex]);
                    if(nextCharValue > charValue) {
                        result += -charValue;
                    }else {
                        result += charValue;
                    }
                //最后一位
                }else {
                    result += convertMap.get(chars[i]);
                }
            }
            return result;
        }


    }


    public static void main(String[] args) {

        /**
         * 1-10之间转换
         */

        Solution s = new Solution();

        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));





    }


}
