package com.zp.leetcode.package2022.june.june06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/6 3:38 下午
 **/
public class ToHex {
    Map<Long,Character> map = new HashMap<Long,Character>(){
        {
            put(0L,'0');
            put(1L,'1');
            put(2L,'2');
            put(3L,'3');
            put(4L,'4');
            put(5L,'5');
            put(6L,'6');
            put(7L,'7');
            put(8L,'8');
            put(9L,'9');
            put(10L,'a');
            put(11L,'b');
            put(12L,'c');
            put(13L,'d');
            put(14L,'e');
            put(15L,'f');


        }
    };


    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        long longNum = num;
        if (num < 0) {
            longNum = (long) (Math.pow(2, 32) + num);
        }
        while (longNum > 0) {
            long a0 = longNum % 16 ;
            sb.append(map.get(a0));
            longNum =  longNum / 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ToHex toHex = new ToHex();
        //System.out.println(toHex.toHex(26));
        //System.out.println(toHex.toHex(-1));
        System.out.println(toHex.toHex(16));
    }
}
