package com.zp.leetcode.package2022.july.july20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/7/20 9:09 上午
 * 二维网格迁移
 **/
public class ShiftGrid {

    public static void main(String[] args) {

        ShiftGrid shiftGrid = new ShiftGrid();
        int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        System.out.println(shiftGrid.shiftGrid(grid,k));

    }



    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        while(k > 0){
            //存放下一个临时结果
            int m = grid.length, n = grid[0].length;
            int[][] nums = new int[m][n];
            //遍历整个数组
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    //第三种情况
                    if(i == m - 1 && j == n - 1){
                        nums[0][0] = grid[i][j];
                        continue;
                    }
                    //第二种那个情况
                    if(i != m - 1 && j == n - 1){
                        nums[i + 1][0] = grid[i][j];
                        continue;
                    }
                    //第一种情况
                    nums[i][j + 1] = grid[i][j];
                }
            }
            grid = nums;
            k--; //迁移次数减一
        }
        //存放结果
        for(int i = 0; i < grid.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++){
                temp.add(grid[i][j]);
            }
            result.add(temp);
        }
        return result;

    }
}
