package com.zp.leetcode.package2023.june.june05;

/**
 * @author zhengpeng
 * @date 2023/6/5 10:27
 * 统计范围内的元音字符串数
 **/
public class VowelStrings {

    public static void main(String[] args) {
        VowelStrings vowelStrings = new VowelStrings();
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][]{{}};
        vowelStrings.vowelStrings(words,queries);
    }


    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] suffixes = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            suffixes[i + 1] = suffixes[i] + value;
        }
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            ans[i] = suffixes[end + 1] - suffixes[start];
        }
        return ans;
    }

    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
