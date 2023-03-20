package com.zp.leetcode.package2023.march.march20;

/**
 * @author zhengpeng
 * @date 2023/3/20 2:50 下午
 * 6和9组成的最大数字
 **/
public class Maximum69Number {

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        //int num = 996;
        //int num = 9999;
        int num = 9669;
        System.out.println(maximum69Number.maximum69Number(num));
    }

    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        int changeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(changeCount == 0 && c == '6'){
                sb.append('9');
                changeCount++;
            }else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
