package com.zp.leetcode.package2022.december.december15;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/12/15 9:40 上午
 **/
public class Lucky {

    public static void main(String[] args) {
        Lucky lucky = new Lucky();
        //String s = "iiii";
        String s = "leetcode";
        //int k = 1;
        int k = 2;
        System.out.println(lucky.getLucky(s,k));

    }

    public int getLucky(String s, int k) {
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('a',"1");
            put('b',"2");
            put('c',"3");
            put('d',"4");
            put('e',"5");
            put('f',"6");
            put('g',"7");
            put('h',"8");
            put('i',"9");
            put('j',"10");
            put('k',"11");
            put('l',"12");
            put('m',"13");
            put('n',"14");
            put('o',"15");
            put('p',"16");
            put('q',"17");
            put('r',"18");
            put('s',"19");
            put('t',"20");
            put('u',"21");
            put('v',"22");
            put('w',"23");
            put('x',"24");
            put('y',"25");
            put('z',"26");
        }};

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++){
            sb.append(map.get(s.charAt(i)));
        }
        int ans = 0;
        while (k != 0){
            ans = 0;
            int sbLen = sb.length();
            String temp = sb.toString();
            for (int i = 0; i < sbLen; i++) {
                ans += Integer.parseInt(String.valueOf(temp.charAt(i)));
            }
            sb = new StringBuilder(String.valueOf(ans));
            k--;
        }
        return ans;
    }
}
