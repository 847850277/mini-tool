package com.zp.leetcode.package2022.november.november05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/11/5 9:47 上午
 * 解析布尔表达式
 **/
public class ParseBoolExpr {


    public static void main(String[] args) {

        //String expression = "!(f)";
        //String expression = "|(f,t)";
        String expression = "|(&(t,f,t),!(t))";
        ParseBoolExpr parseBoolExpr = new ParseBoolExpr();
        System.out.println(parseBoolExpr.parseBoolExpr(expression));


    }

    /**
     * 抽象成无数个小规模的方法
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int n = expression.length();
        // 遍历表达式字符串
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int tCount = 0, fCount = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        tCount++;
                    } else {
                        fCount++;
                    }
                }
                stack.pop();
                //操作符号
                char op = stack.pop();
                switch (op) {
                    case '!':
                        stack.push(fCount == 1 ? 't' : 'f');
                        break;
                    case '&':
                        stack.push(fCount == 0 ? 't' : 'f');
                        break;
                    case '|':
                        stack.push(tCount > 0 ? 't' : 'f');
                        break;
                    default:
                }
            }
        }
        return stack.pop() == 't';
    }
}
