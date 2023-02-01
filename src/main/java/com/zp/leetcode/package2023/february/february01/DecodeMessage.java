package com.zp.leetcode.package2023.february.february01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/2/1 9:27 上午
 * 解密消息
 **/
public class DecodeMessage {

    public static void main(String[] args) {

        /*

        char a = 'a';
        int i = a + 1;
        int i1 = a + 2;
        System.out.println(i);
        System.out.println(i1);

        char c = (char)i;
        System.out.println(c);

        */

        DecodeMessage decodeMessage = new DecodeMessage();
        //String key = "the quick brown fox jumps over the lazy dog";
        //String message = "vkbs bs t suepuv";

        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage.decodeMessage(key,message));

    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> keyMap = new HashMap<>();
        char a = 'a';
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!keyMap.containsKey(c) && c != ' ') {
                int num = a + index;
                char cc = (char) (num);
                keyMap.put(c,cc);
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (keyMap.containsKey(c)) {
                c = keyMap.get(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
