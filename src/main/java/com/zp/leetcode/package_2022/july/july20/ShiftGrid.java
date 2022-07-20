package com.zp.leetcode.package_2022.july.july20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/7/20 9:09 上午
 * 二维网格迁移
 **/
public class ShiftGrid {

    public static void main(String[] args) {

    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //展开到一维中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.add(grid[i][j]);
            }
        }
        //移动k次
        for (int i = 0; i < k; i++) {
            temp.add(0, temp.remove(temp.size() - 1));
        }
        int i = 0;
        //封装结果
        while (i < temp.size()) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(temp.get(i));
                i++;
            }
            ans.add(row);
        }
        return ans;
    }

}
