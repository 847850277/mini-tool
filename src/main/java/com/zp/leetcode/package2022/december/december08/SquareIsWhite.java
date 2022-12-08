package com.zp.leetcode.package2022.december.december08;

/**
 * @author zhengpeng
 * @date 2022/12/8 9:00 上午
 * 判断国际象棋棋盘中一个格子的颜色
 **/
public class SquareIsWhite {

    public static void main(String[] args) {

    }

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;
    }

}
