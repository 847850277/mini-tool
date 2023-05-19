package com.zp.leetcode.package2023.may.may19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2023/5/19 9:55 上午
 * 活字印刷
 * 回溯算法-所有的不重复组合
 **/
public class NumTilePossibilities {

    public static void main(String[] args) {

        NumTilePossibilities numTilePossibilities = new NumTilePossibilities();
        String str = "AAB";
        //String str = "AABB";
        System.out.println(numTilePossibilities.numTilePossibilities(str));

    }

    public int numTilePossibilities(String tiles) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = tiles.toCharArray();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0) + 1);
        }
        Set<Character> path = new HashSet<>(map.keySet());
        return backTracking(tiles.length(),map,path) - 1;
    }

    private int backTracking(int length, Map<Character, Integer> map, Set<Character> path) {
        if(length == 0){
            return 1;
        }
        int res = 1;
        for (Character character : path) {
            if(map.get(character) > 0){
                map.put(character,map.get(character) - 1);
                res += backTracking(length - 1,map,path);
                map.put(character,map.get(character) + 1);
            }
        }
        return res;
    }
}
