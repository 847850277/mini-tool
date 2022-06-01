package com.zp.leetcode.package_2022.may.may31;

/**
 * @author zhengpeng
 * @date 2022/5/31 4:37 下午
 * 反转元因字母
 **/
public class ReverseVowels {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        boolean leftSwitch = false;
        int right = s.length() - 1;
        boolean rightSwitch = false;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
//            if(!isVowel(c)){
//                sb.insert(i,String.valueOf(c));
//            }else if(!isVowel(c))


        }
        return s;
    }

    public boolean isVowel(Character c){
        Character d = String.valueOf(c).toLowerCase().charAt(0);
        if('a' == d || 'e' == d || 'i' == d || 'o' == d || 'u' == d){
            return true;
        }
        return false;

    }



    public static void main(String[] args) {

        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.isVowel('A'));
        System.out.println(reverseVowels.isVowel('a'));
    }
}
