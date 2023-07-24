package com.zp.leetcode.package2023.july.july24;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2023/7/24 10:26
 * 宝石与石头
 **/
public class NumJewelsInStones {

    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones.numJewelsInStones(jewels,stones));

    }


    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int len = jewels.length();
        for (int i = 0; i < len; i++) {
            char c = jewels.charAt(i);
            set.add(c);
        }
        int len1 = stones.length();
        int count = 0;
        for (int i = 0; i < len1; i++) {
            char c = stones.charAt(i);
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }

}
