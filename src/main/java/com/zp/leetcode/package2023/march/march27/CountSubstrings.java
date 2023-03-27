package com.zp.leetcode.package2023.march.march27;

/**
 * @author zhengpeng
 * @date 2023/3/27 9:08 上午
 * 统计只差一个字符的字串数目
 **/
public class CountSubstrings {


    public static void main(String[] args) {

        String s = "aba";
        String t = "baba";
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings(s,t));
    }

    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff > 1) {
                        break;
                    } else if (diff == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
