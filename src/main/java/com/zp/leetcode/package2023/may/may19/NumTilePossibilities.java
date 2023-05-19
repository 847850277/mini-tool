package com.zp.leetcode.package2023.may.may19;

import java.util.Arrays;
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
        //System.out.println(numTilePossibilities.numTilePossibilities1(str));
        System.out.println(numTilePossibilities.numTilePossibilities(str));

    }



    int res = 0;
    int[] used;
    public int numTilePossibilities(String tiles) {
        used = new int[tiles.length()];
        char[] array = tiles.toCharArray();
        Arrays.sort(array);
        backTracking(array);
        return res;
    }

    private void backTracking(char[] array) {
        for (int i = 0; i < array.length; i++) {
            // 树层去重，前一位没被选上且后一位与前一位相同
            if(i > 0 && used[i-1] == 0 && array[i] == array[i-1]) {
                continue;
            }
            // 自己不能被选两次
            if(used[i] == 1) {
                continue;
            }
            res++;
            used[i] = 1;
            backTracking(array);
            used[i] = 0;
        }
    }


    public int numTilePossibilities1(String tiles) {
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
