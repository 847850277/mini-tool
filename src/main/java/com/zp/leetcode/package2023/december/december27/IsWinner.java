package com.zp.leetcode.package2023.december.december27;

public class IsWinner {

    public static void main(String[] args) {
        //int[] array1 = new int[]{4,10,7,9};
        //int[] array1 = new int[]{3,5,7,6};
        //int[] array1 = new int[]{2,3};
        int[] array1 = new int[]{5,6,1,10};
        //int[] array2 = new int[]{6,5,2,3};
        //int[] array2 = new int[]{8,10,10,2};
        //int[] array2 = new int[]{4,1};
        int[] array2 = new int[]{5,1,10,5};
        IsWinner isWinner = new IsWinner();
        System.out.println(isWinner.isWinner(array1,array2));
    }

    public int isWinner(int[] player1, int[] player2) {
       int s1 = score(player1);
       int s2 = score(player2);
       return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
    }

    private int score(int[] player) {
        int res = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] >= 10)) {
                res += 2 * player[i];
            } else {
                res += player[i];
            }
        }
        return res;
    }
}
