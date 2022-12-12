package com.zp.leetcode.package2022.december.december12;

/**
 * @author zhengpeng
 * @date 2022/12/12 9:10 上午
 * 所有子字符串美丽值之和
 **/
public class BeautySum {

    public static void main(String[] args) {
        String s = "aabcb";
        BeautySum beautySum = new BeautySum();
        System.out.println(beautySum.beautySum(s));
    }

    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}
