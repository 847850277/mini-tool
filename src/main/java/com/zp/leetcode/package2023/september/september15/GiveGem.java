package com.zp.leetcode.package2023.september.september15;

public class GiveGem {

    public static void main(String[] args) {
        //int[] gem = new int[]{3,1,2};
        int[] gem = new int[]{100,0,50,100};
        //int[][] op = new int[][]{{0,2},{2,1},{2,0}};
        int[][] op = new int[][]{{0,2},{0,1},{3,0},{3,0}};
        GiveGem giveGem = new GiveGem();
        int i = giveGem.giveGem(gem, op);
        System.out.println(i);
    }


    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int needGive = gem[operation[0]] / 2;
            gem[operation[1]] += needGive;
            gem[operation[0]] -= needGive;
        }

        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for (int i : gem) {
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        return max - min;

    }
}
