package com.zp.leetcode.package2023.december.december13;

public class MakeSmallestPalindrome {

    public static void main(String[] args) {
        String s = "egcfe";
        //String s = "abcd";
        //String s = "seven";
        MakeSmallestPalindrome makeSmallestPalindrome = new MakeSmallestPalindrome();
        System.out.println(makeSmallestPalindrome.makeSmallestPalindrome(s));

        int a = -1;
        boolean flag = a > 0 ? true : false;

        System.out.println(flag);

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = b1 || b2;
        System.out.println(b3);
    }




    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left != right && left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            left++;
            right--;
            if(leftChar <= rightChar){
                sb.append(leftChar);
            }else {
                sb.append(rightChar);
            }
        }
        if(left == right){
            String tempSb = sb.toString();
            sb.append(s.charAt(right))
                    .append(new StringBuilder(tempSb).reverse());
        }
        if(left > right){
            String tempSb = sb.toString();
            sb.append(new StringBuilder(tempSb).reverse());
        }
        return sb.toString();
    }
}
