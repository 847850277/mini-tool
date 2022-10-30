package com.zp.leetcode.package2022.october.october30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/10/30 10:36 上午
 * 字母大小写全排列
 **/
public class LetterCasePermutation {

    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }



}
