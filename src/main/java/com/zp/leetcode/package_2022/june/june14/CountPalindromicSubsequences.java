package com.zp.leetcode.package_2022.june.june14;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/10 9:01 上午
 * 统计不同的回文子序列
 **/
public class CountPalindromicSubsequences {




    /**
     *
     * @param s
     * @return
     */
    public int countPalindromicSubsequences(String s) {
        char[] arrays = s.toCharArray();
        Set<String> result = new HashSet<>();
        backtrack(0,arrays,result,new Stack<Character>());
        long size = result.size();
        return (int) (size % 1000000007);
    }

    /**
     * 回溯
     * @param i
     * @param arrays
     * @param result
     * @param path
     */
    private void backtrack(int i, char[] arrays, Set<String> result, Stack<Character> path) {
        String str = getStr(path);
        if(!path.isEmpty() && isPalindrome(str)){
            result.add(str);
        }
        for (int j = i; j < arrays.length; j++) {
            char character = arrays[j];
            path.add(character);
            backtrack(j + 1,arrays,result,path);
            path.pop();
            System.out.println(j);
        }
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    private String getStr(Stack<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountPalindromicSubsequences countPalindromicSubsequences = new CountPalindromicSubsequences();
        //System.out.println(countPalindromicSubsequences.countPalindromicSubsequences("bccb"));
        System.out.println(countPalindromicSubsequences.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }


}
