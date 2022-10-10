package com.zp.leetcode.package2022.october.october02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/10/9 4:50 下午
 * 括号的分数
 * 栈模拟
 * 使用 ret 记录层级，
 * 当前字符为 ( 时，将 ret 推入栈中，并重置计数；当前字符为 ) 时，将 ret 翻倍，这个值至少为 1，同时推出当前层级，加和上一层计数。
 **/
public class ScoreOfParentheses {



    public int scoreOfParentheses(String s) {

        Deque<Integer> queue = new ArrayDeque<>();
        int ret = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                queue.offerLast(ret);
                ret = 0;
            } else {
                ret = queue.pollLast() + Math.max(2 * ret, 1);
            }
        }
        return ret;

    }
}
