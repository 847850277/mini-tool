package com.zp.leetcode.package2022.december.december28;

/**
 * @author zhengpeng
 * @date 2022/12/28 9:25 上午
 * 删除字符串两端相同字符串后的最短长度
 **/
public class MinimumLength {

    public static void main(String[] args) {
        MinimumLength m = new MinimumLength();
        //String s = "ca";
        //String s = "cabaabac";
        //String s = "aabccabba";
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println(m.minimumLength(s));
    }

    public int minimumLength(String s) {
        if(s.length() == 1){
            return s.length();
        }
        int left = 0;
        int right = s.length() - 1;
        char c = s.charAt(left);
        if (s.charAt(left) != s.charAt(right)){
            return s.length();
        }else {
            while (s.charAt(left) == c){
                left++;
                if(left == right){
                    return 0;
                }
            }
            while (s.charAt(right) == c){
                right--;
            }
            return minimumLength(s.substring(left,right + 1));
        }
    }
}
