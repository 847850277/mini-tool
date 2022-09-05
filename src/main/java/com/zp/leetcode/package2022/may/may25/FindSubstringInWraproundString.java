package com.zp.leetcode.package2022.may.may25;

import java.util.*;


/**
 * @author zhengpeng
 * @date 2022/5/25 9:04 上午
 * 环绕字符串中唯一的子字符串
 **/
public class FindSubstringInWraproundString {
    Map<Character,Character> map = new HashMap<Character,Character>(){
        {
            put('b','a');
            put('c','b');
            put('d','c');
            put('e','d');
            put('f','e');
            put('g','f');
            put('h','g');
            put('i','h');
            put('j','i');
            put('k','j');
            put('l','k');
            put('m','l');
            put('n','m');
            put('o','n');
            put('p','o');
            put('q','p');
            put('r','q');
            put('s','r');
            put('t','s');
            put('u','t');
            put('v','u');
            put('w','v');
            put('x','w');
            put('y','x');
            put('z','y');
            put('a','z');
        }
    };

    public int findSubstringInWraproundString(String p) {

        final long startTime = System.currentTimeMillis();
        if(p.length() == 1){
            return 1;
        }
        Set<String> set = new HashSet<String>();
        int length = p.length();
        //开始位置索引
        int start = 0;
        Map<Character,Character> pointer = new HashMap();
        Character pre = p.charAt(0);
        for (int i = 1; i < length; i++) {
            final char c = p.charAt(i);
            pointer.put(c,pre);
            pre = c;
            //判断是否满足
            final Character character = map.get(c);
            final Character character1 = pointer.get(c);
            //不满足
            if(!character.equals(character1)){
                final String substring = p.substring(start, i);
                bulidSet(set,substring);
                start = i;
            }
            //若是最后一个且满足
            // && character.equals(character1)
            if(i == length - 1 ){
                bulidSet(set,p.substring(start,i + 1));
            }

        }
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return set.size();
    }

    /**
     * 构建子串
     * @param set
     * @param substring 满足条件的子串
     */
    private void bulidSet(Set<String> set, String substring) {
        int length = substring.length();
//        for (int i = 1; i <= length; i++) {
//            for(int j = i;j <= length;j++){
//                final String substring1 = substring.substring(j - i, j);
//                set.add(substring1);
//            };
//        }
        if(!set.contains(substring)){
            for (int i = 1; i <= length; i++) {
                for(int j = i;j <= length;j++){
                    final String substring1 = substring.substring(j - i, j);
                    set.add(substring1);
                };
            }
        }
        //System.out.println(set);
    }


    /**
     * 动态规划，由于子串最长为26，今后的子串便会循环
     * @param p
     * @return
     */
    public int findSubstringInWraproundString1(String p) {
        final long startTime = System.currentTimeMillis();
        int length = p.length();
        //存储以字符结尾的个数
        int[] counts = new int[26];
        //第一个字符默认一个
        counts[p.charAt(0) - 'a'] = 1;
        int count = 1;
        for (int i = 1; i < length; i++) {
            //当前字符
            char curChar = p.charAt(i);
            //前一个字符
            char lastChar = p.charAt(i - 1);
            //是否连续
            int remainder = (curChar - lastChar) % 26;
            //相差1或者-25（za） 表示连续
            if (remainder == 1 || remainder == -25) {
                count++;
            } else {
                count = 1;
            }
            //更新以字符curChar结尾的子串数量，有重复结尾的字符，以最大的为准
            counts[curChar - 'a'] = Math.max(count, counts[curChar - 'a']);
        }
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return Arrays.stream(counts).sum();
    }



    public static void main(String[] args) {

        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zabc"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("a"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("cac"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString1("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString1("zip"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString1("zabc"));
        //System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zip"));
        //findSubstringInWraproundString.bulidSet(new HashSet<String>(),"zab");

    }
}
