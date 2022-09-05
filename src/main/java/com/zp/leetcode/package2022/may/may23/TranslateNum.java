package com.zp.leetcode.package2022.may.may23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/5/20 4:23 下午
 * 把数字翻译成字符串
 * 0 - 25
 * a - z
 **/
public class TranslateNum {

    Map<String,String> keyValueMap = new HashMap<String,String>(){
        {
            put("0","a");
            put("1","b");
            put("2","c");
            put("3","d");
            put("4","e");
            put("5","f");
            put("6","g");
            put("7","h");
            put("8","i");
            put("9","j");
            put("10","k");
            put("11","l");
            put("12","m");
            put("13","n");
            put("14","o");
            put("15","p");
            put("16","q");
            put("17","r");
            put("18","s");
            put("19","t");
            put("20","u");
            put("21","v");
            put("22","w");
            put("23","x");
            put("24","y");
            put("25","z");
        }
    };


    public int translateNum(int num) {
        String str = String.valueOf(num);
        int result = 1;
        //最多组团次数
        int groupMax = num / 2;
        for (int i = 1; i <= groupMax; i++) {
            result+= getSubSum(str,i);
        }
        return result;
    }

    /**
     * 满足条件子数组的和
     * @param str
     * @param times 切割次数
     * @return
     */
    private int getSubSum(String str, int times) {
        int result = 0;
        int splitTime = 0;
        int splitRange = 2 ;

        final int end = str.length();
        int start = 0;
        while (splitTime < times){
            final String substring = str.substring(start * splitTime * 2, 2);
            if(keyValueMap.containsKey(substring)){
                splitTime++;
            }else{
                start++;
            }
            //减出去的逻辑？


        }
        return result;
    }

    public static void main(String[] args) {

        TranslateNum tn = new TranslateNum();
        tn.translateNum(12);

    }

}
