package com.zp.leetcode.package2023.june.june02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/6/2 09:20
 * 统计范围内的元音字符串数
 **/
public class VowelStrings {


    public static void main(String[] args) {
        VowelStrings vowelStrings = new VowelStrings();
        String[] words = new String[]{"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][]{{0,2},{1,4},{1,1}};
        int[] ints = vowelStrings.vowelStrings(words, queries);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            prefixSums[i + 1] = prefixSums[i] + value;
        }
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            ans[i] = prefixSums[end + 1] - prefixSums[start];
        }
        return ans;
    }

    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int[] vowelStrings0(String[] words, int[][] queries) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("e", "e");
        map.put("i", "i");
        map.put("o", "o");
        map.put("u", "u");
        int[] ans = new int[queries.length];
        int index = 0;
        Boolean[] booleans = new Boolean[words.length];
        for (String word : words) {
            String substring0 = word.substring(0, 1);
            int length = word.length();
            String substring1 = substring0;
            if(length != 1){
                substring1 = word.substring( length - 1, length);
            }
            if (map.containsKey(substring0) && map.containsKey(substring1)) {
                booleans[index] = true;
            }else {
                booleans[index] = false;
            }
            index++;
        }
        index = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int count = 0;
            for (int i = start; i <= end; i++) {
                Boolean aBoolean = booleans[i];
                if(aBoolean){
                    count++;
                }
            }
            ans[index] = count;
            index++;
        }
        return ans;
    }

}
