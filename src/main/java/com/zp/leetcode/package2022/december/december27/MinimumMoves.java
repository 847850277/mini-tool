package com.zp.leetcode.package2022.december.december27;

/**
 * @author zhengpeng
 * @date 2022/12/27 5:23 下午
 **/
public class MinimumMoves {

    public static void main(String[] args) {

        //System.out.println(Math.pow(3,1));
        //System.out.println(Math.pow(3,2));
        //String s = "XXX";
        String s = "XXOX";
        MinimumMoves m = new MinimumMoves();
        System.out.println(m.minimumMoves(s));

    }


    public int minimumMoves(String s) {
        int covered = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X' && i > covered) {
                res++;
                covered = i + 2;
            }
        }
        return res;
    }
}
