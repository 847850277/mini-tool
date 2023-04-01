package com.zp.leetcode.package2023.april.april01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/4/1 1:53 下午
 * 隐藏个人信息
 **/
public class MaskPII {

    public static void main(String[] args) {

        MaskPII maskPII = new MaskPII();
        //String str = "LeetCode@LeetCode.com";
        //String str = "AB@qq.com";
        String str = "1(234)567-890";
        System.out.println(maskPII.maskPII(str));

    }

    public Map<Character,Character> cMap = new HashMap(){{
        put('+','+');
        put('-','-');
        put('(','(');
        put(')',')');
        put(' ',' ');
    }};

    public Map<Character,Character> numberMap = new HashMap(){{
        put('0','0');
        put('1','1');
        put('2','2');
        put('3','3');
        put('4','4');
        put('5','5');
        put('6','6');
        put('7','7');
        put('8','8');
        put('9','9');
    }};

    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        if(isEmail(s)){
            String[] split = s.split("@");
            String left = split[0];
            sb.append(left.substring(0,1).toLowerCase())
                    .append("*****")
                    .append(left.substring(left.length() - 1,left.length()).toLowerCase())
                    .append("@");
            String right = split[1];
            sb.append(right.toLowerCase());
            return sb.toString();
        }else {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if(numberMap.containsKey(c)){
                    sb.append(c);
                }
            }
            len = sb.length();
            if(len == 10){
                return "***-***-" + sb.substring(len - 4,len);
            }else if (len == 11){
                return "+*-***-***-" + sb.substring(len - 4,len);
            }else if(len == 12){
                return "+**-***-***-" + sb.substring(len - 4,len);
            }else if(len == 13){
                return "+***-***-***-" + sb.substring(len - 4,len);
            }
        }
        return null;
    }

    private boolean isEmail(String s) {
        if(s.contains("@")){
            return true;
        }
        return false;
    }
}
