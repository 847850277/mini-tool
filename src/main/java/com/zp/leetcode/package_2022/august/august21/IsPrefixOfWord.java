package com.zp.leetcode.package_2022.august.august21;

/**
 * @author zhengpeng
 * @date 2022/8/21 10:50 上午
 * 检查单词是否为句中其他单词的前缀
 **/
public class IsPrefixOfWord {


    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 1;
        final String[] s = sentence.split(" ");
        for (String s1 : s) {
            if(s1.startsWith(searchWord)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
