package com.zp.leetcode.package2022.april.april0408;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022-04-08 09:01
 * 有效括号
 **/
public class ValidBrackets {

    Map<Character,Character> leftMap = new HashMap(){{
        put('(',')');
        put('{','}');
        put('[',']');
    }};
    Map<Character,Character> rightMap = new HashMap(){{
        put(')','(');
        put('}','{');
        put(']','[');
    }};


    /**
     * 判断括号是否有效
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //边界
        if(chars.length % 2 != 0){
            return false;
        }
        //边界
        if(s.startsWith(")") || s.startsWith("}") || s.startsWith("]")){
            return false;
        }
        for (char c : chars) {
            if(leftMap.containsKey(c)){
                stack.push(c);
            }else if(rightMap.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(!rightMap.get(c).equals(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidBrackets v = new ValidBrackets();
        //System.out.println(v.isValid("()"));
        //System.out.println(v.isValid("()[]{}"));
        //System.out.println(v.isValid("(]"));
        //System.out.println(v.isValid("([)]"));
        //System.out.println(v.isValid("{[]}"));
        //System.out.println(v.isValid("(("));
        //System.out.println(v.isValid("}("));
        System.out.println(v.isValid("(){}}{"));

    }
}
