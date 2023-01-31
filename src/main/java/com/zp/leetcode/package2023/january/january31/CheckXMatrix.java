package com.zp.leetcode.package2023.january.january31;

/**
 * @author zhengpeng
 * @date 2023/1/31 10:20 上午
 * 判断矩阵是否是一个X矩阵
 **/
public class CheckXMatrix {

    public static void main(String[] args) {


    }

    public boolean checkXMatrix(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //在对角线
                if(i == j || (i + j) == (length - 1)){
                    if(grid[i][j] == 0){
                        return false;
                    }
                //不在对角线
                }else if(grid[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

}
