package com.zp.leetcode.package2022.july.july11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/7/11 9:12 上午
 * 魔法字典
 **/
public class MagicDictionary {


    private Map<String,Integer> dictionary;

    public MagicDictionary() {
        dictionary = new HashMap<String,Integer>();
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }

    public void buildDict(String[] dictionary) {
        Map<String, Integer> dictionaryMap = getDictionary();
        for (String s : dictionary) {
            dictionaryMap.put(s, s.length());
        }
    }

    public boolean search(String searchWord) {
        boolean result = false;
        final int length = searchWord.length();
        for (String s : dictionary.keySet()) {
            int matchCount = 0;
            if (s.length() != length) {
                continue;
            }else{
                if(searchWord.equals(s)){
                    continue;
                }
                for (int i = 0; i < length; i++) {
                    final char charAt = s.charAt(i);
                    final char charAt1 = searchWord.charAt(i);
                    if(charAt == charAt1){
                        matchCount++;
                    }
                }
            }
            if(matchCount == length - 1){
                result = true;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary  = new MagicDictionary();
        String[] array = new String[]{"hello","leetcode"};
        magicDictionary.buildDict(array);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));

    }

}
