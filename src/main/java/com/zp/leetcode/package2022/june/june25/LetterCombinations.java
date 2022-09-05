package com.zp.leetcode.package2022.june.june25;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/25 9:52 上午
 * 电话号码的字母组合
 **/
public class LetterCombinations {


    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        Stack<Character> path = new Stack<>();
        backtrack(result, path, digits, 0);
        return result;
    }

    /**
     * 回溯
     *
     * @param result
     * @param path
     * @param digits
     * @param i
     */
    private void backtrack(List<String> result, Stack<Character> path, String digits, int i) {
        //确定终止条件
        if (path.size() == digits.length()) {
            result.add(parseStr(path));
            return;
        }
        final char charAt = digits.charAt(i);
        final String s = map.get(charAt);
        for (int j = 0; j < s.length(); j++) {
            path.push(s.charAt(j));
            //backtrack(result,path,digits,j++);
            backtrack(result, path, digits, i + 1);
            path.pop();
        }
    }


    private String parseStr(Stack<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        return sb.toString();
    }


    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack1(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack1(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        //System.out.println(letterCombinations.letterCombinations1("23"));
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
