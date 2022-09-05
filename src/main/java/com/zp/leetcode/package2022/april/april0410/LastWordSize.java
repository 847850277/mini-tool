package com.zp.leetcode.package2022.april.april0410;

/**
 * @author zhengpeng
 * @date 2022-04-10 17:28
 * 最后一个单词的长度
 **/
public class LastWordSize {

    /**
     * 最后一个单词长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int lastWordSize = 0;
        // 处理空格
        s = s.trim();
        int size = s.length();
        for (int i = size - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if(c != ' '){
                lastWordSize++;
            }else if(c == ' '){
                return lastWordSize;
            }
        }
        return lastWordSize;
    }

    public static void main(String[] args) {

        LastWordSize l = new LastWordSize();

        //System.out.println(l.lengthOfLastWord("Hello World"));
        //System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(l.lengthOfLastWord("luffy is still joyboy"));


    }

}
