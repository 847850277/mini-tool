package com.zp.leetcode.package2022.june.june29;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhengpeng
 * @date 2022/6/29 9:15 上午
 * TinyURL的加密与解密
 **/
public class Codec {

    Map<String,String> map = new HashMap<String,String>();

    public String encode(String longUrl) {
        final int code = longUrl.hashCode();
        String s = "http://a.com/"+code;
        map.put(s,longUrl);
        return s;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    //TODO 减少哈希碰撞


    Map<String,String> map1 = new HashMap<String,String>();

    public String encode1(String longUrl) {
        //不用url的hashCode，
        int length = 10;
        String code = getRandomString(length);
        while (map1.containsKey(code)){
            code = getRandomString(length);
        }
        String s = "http://a.com/"+code;
        map.put(s,longUrl);
        return s;
    }

    public String decode1(String shortUrl) {
        return map.get(shortUrl);
    }


    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }






    public static void main(String[] args) {

        Codec code = new Codec();
        String shortUrl = code.encode1("https://leetcode.com/problems/design-tinyurl");
        System.out.println(shortUrl);
        System.out.println(code.decode1(shortUrl));



    }
}
