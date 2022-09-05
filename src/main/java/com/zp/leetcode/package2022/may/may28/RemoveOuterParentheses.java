package com.zp.leetcode.package2022.may.may28;

/**
 * @author zhengpeng
 * @date 2022/5/28 11:00 上午
 * 删除最外层括号
 **/
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, score = 0; i < n; ) {
            int j = i;
            while (i == j || score != 0) {
                score += cs[j++] == '(' ? 1 : -1;
            }
            sb.append(s.substring(i + 1, j - 1));
            i = j;
            score = 0;
        }
        return sb.toString();
    }

}
