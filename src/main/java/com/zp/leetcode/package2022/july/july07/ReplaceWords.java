package com.zp.leetcode.package2022.july.july07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/7/7 9:20 上午
 * 单词替换
 **/
public class ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        /*
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
         */

        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");

        //String sentence = "the cattle was rattled by the battery";
        String sentence = "aadsfasf absbs bbab cadsfafs";

        ReplaceWords replaceWords = new ReplaceWords();
        System.out.println(replaceWords.replaceWords(dictionary,sentence));

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Map<String,String> dictionaryMap = new HashMap<String,String>();
        for (String s : dictionary) {
            dictionaryMap.put(s,s);
        }
        List<String> replaceWords = new ArrayList<>();
        final String[] split = sentence.split(" ");
        for (String s : split) {
            int length = s.length();
            boolean hasRoot =  false;
            for (int i = 1; i < length; i++) {
                final String substring = s.substring(0, i);
                if(dictionaryMap.containsKey(substring)) {
                    replaceWords.add(substring);
                    hasRoot = true;
                    break;
                }
            }
            if(!hasRoot){
                replaceWords.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replaceWords.size(); i++) {
            final String s = replaceWords.get(i);
            if(i != replaceWords.size() - 1){
                sb.append(s).append(" ");
            }else{
                sb.append(s);
            }
        }
        return sb.toString();
    }


}
