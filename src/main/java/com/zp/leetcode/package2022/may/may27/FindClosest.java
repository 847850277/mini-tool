package com.zp.leetcode.package2022.may.may27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/5/27 9:19 上午
 * 单词距离
 **/
public class FindClosest {

    /**
     * 最近的单词距离
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int minSize = Integer.MAX_VALUE;
        String firstFindWords = "";
        int length = words.length;
        Map<String,Integer> keyIndex = new HashMap<String,Integer>();
        for (int i = 0; i < length; i++) {
            final String word = words[i];
            //把第一个找到的单词放进去
            if((word.equals(word1) || word.equals(word2)) && "".equals(firstFindWords)){
                firstFindWords = word;
                keyIndex.put(word,i);
                continue;
            }
            //第二个单词
            if(word.equals(word1) || word.equals(word2)){
                //第二个找到的和第一个相同,替换下标位置
                if(word.equals(firstFindWords)){
                    keyIndex.put(word,i);
                }else {
                    //第二个找到的和第一个不相同,计算差别
                    keyIndex.put(word, i);
                    int diff = (i - keyIndex.get(firstFindWords));
                    minSize = Math.min(diff,minSize);
                    //剔除前一个元素
                    keyIndex.remove(firstFindWords);
                    //第一个单词替换
                    firstFindWords = word;
                }
            }
        }

        return  minSize;
    }

    public static void main(String[] args) {
        FindClosest findClosest = new FindClosest();
        //String[] array = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        String[] array = new String[]{"I","am","a","little","student","from","student","a","university","in","a","city"};
        String s1 = "a";
        String s2 = "student";
        System.out.println(findClosest.findClosest(array,s1,s2));
    }
}
