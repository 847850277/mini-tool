package com.zp.leetcode.package2023.august.august07;

/**
 * 翻转字符串
 */
public class ReverseString {


    public static void main(String[] args) {


    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
