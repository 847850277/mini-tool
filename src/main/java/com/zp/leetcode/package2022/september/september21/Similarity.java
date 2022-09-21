package com.zp.leetcode.package2022.september.september21;

/**
 * @author zhengpeng
 * @date 2022/9/21 3:09 下午
 * 相识度为k的字符串
 **/
public class Similarity {

    int result = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        return backtrack(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int backtrack(char[] sc1, char[] sc2, int start, int current) {
        if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
        if (start == sc1.length - 1) return result = Math.min(current, result);

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                        swap(sc2, i, j); // 交换
                        backtrack(sc1, sc2, i + 1, current + 1);
                        swap(sc2, i, j); // 回溯
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return result;
            }
        }
        return result = Math.min(current, result);
    }

    public void swap(char[] sc, int i, int j) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }

}
