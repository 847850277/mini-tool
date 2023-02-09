package com.zp.leetcode.package2023.february.february09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/2/9 9:58 上午
 * 设计一个验证系统
 **/
public class AuthenticationManager {

    public static void main(String[] args) {
        AuthenticationManager a = new AuthenticationManager(5);
        a.renew("aaa",1);
        a.generate("aaa",2);
        System.out.println(a.countUnexpiredTokens(6));
        a.generate("bbb",7);
        a.renew("aaa",8);
        a.renew("bbb",10);
        System.out.println(a.countUnexpiredTokens(15));


    }


    private Integer timeToLive;
    private Map<String,Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.getOrDefault(tokenId, 0) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        //总存活时间
        int res = 0;
        for (int time : map.values()) {
            if (time > currentTime) {
                res++;
            }
        }
        return res;
    }

}
