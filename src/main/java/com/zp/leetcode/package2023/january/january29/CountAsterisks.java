package com.zp.leetcode.package2023.january.january29;

/**
 * @author zhengpeng
 * @date 2023/1/29 9:15 上午
 * 统计星号
 **/
public class CountAsterisks {

    public static void main(String[] args) {
        CountAsterisks countAsterisks = new CountAsterisks();
        String s = "l|*e*et|c**o|*de|";
        System.out.println(countAsterisks.countAsterisks(s));
    }

    public int countAsterisks(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '|'){
                valid = !valid;
            }else if (c == '*' && valid){
                res++;
            }
        }
        return res;
    }
}
