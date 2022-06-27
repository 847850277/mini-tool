package com.zp.leetcode.package_2022.june.june28;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/27 9:58 上午
 * 括号生成
 **/
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        //System.out.println(generateParenthesis.generateParenthesis(3));
        System.out.println(generateParenthesis.generateParenthesis1(3));
    }


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        int length = n * 2;
        Stack<Character> path = new Stack<>();
        Set<String> sets = new HashSet<>();
        char[] pairs = new char[length];
        for (int i = 0; i < length; i++) {
            if(i % 2 == 0){
                pairs[i] = '(';
            }else {
                pairs[i] = ')';
            }
        }
        backtrack(sets,path,length,pairs,0);
        System.out.println(sets);
        return result;
    }

    /**
     * 回溯
     * @param sets
     * @param path
     * @param length
     * @param pairs
     */
    private void backtrack(Set<String> sets, Stack<Character> path, int length, char[] pairs,int index) {
        if(path.size() == length){
            sets.add(pathToString(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            path.push(pairs[index]);
            backtrack(sets,path,length,pairs,i  + 1);
            path.pop();
        }
    }

    private String pathToString(Stack<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        return sb.toString();
    }


    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<String>();
        backtrack1(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    /**
     * 回溯
     * @param res
     * @param cur
     * @param left
     * @param right
     * @param max
     */
    public void backtrack1(List<String> res, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            backtrack1(res, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            backtrack1(res, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


}
