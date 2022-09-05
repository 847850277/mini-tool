package com.zp.leetcode.package2022.june.june28;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/27 9:58 上午
 * 括号生成
 **/
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
        System.out.println(generateParenthesis.generateParenthesis1(3));
    }


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        Stack<Character> path = new Stack<>();
        backtrack(result,path,0,0,n);
        return result;
    }

    private void backtrack(List<String> result, Stack<Character> path, int left, int right, int n) {
        //终止条件
        if(path.size() == n * 2){
            final String s = pathToString(path);

            result.add(s);
            return;
        }
        if(left < n){
            path.push('(');
            backtrack(result,path,left + 1 ,right,n);
            path.pop();
        }

        //right小于n的时候，需要判断路径生成的括号是否满足规则
//        if(right < n){
//            path.push(')');
//            backtrack(result,path,left,right + 1,n);
//            path.pop();
//        }

        if(right < left){
            path.push(')');
            backtrack(result,path,left,right + 1,n);
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
