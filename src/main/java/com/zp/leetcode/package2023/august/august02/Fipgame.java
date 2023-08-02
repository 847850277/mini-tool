package com.zp.leetcode.package2023.august.august02;

import java.util.HashSet;
import java.util.Set;

/**
 * 翻转卡片游戏
 */
public class Fipgame {

    public static void main(String[] args) {
        int[] fronts = new int[]{1,2,4,4,7};
        int[] backs = new int[]{1,3,4,1,3};
        Fipgame fipgame = new Fipgame();
        System.out.println(fipgame.flipgame(fronts,backs));

    }
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if(fronts[i] == backs[i]){
                same.add(fronts[i]);
            }
        }
        int res = 3000;
        for (int front : fronts) {
            if(front < res && !same.contains(front)){
                res = front;
            }
        }

        for (int back : backs) {
            if(back < res && !same.contains(back)){
                res = back;
            }
        }
        return res % 3000;
    }
}
