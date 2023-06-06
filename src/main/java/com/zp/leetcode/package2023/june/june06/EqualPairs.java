package com.zp.leetcode.package2023.june.june06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengpeng
 * @date 2023/6/6 10:50
 * 相等行列对
 **/
public class EqualPairs {

    public static void main(String[] args) {
        EqualPairs equalPairs = new EqualPairs();
        //int[][] array = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        //int[][] array = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int[][] array = new int[][]{{13,13},{13,13}};
        //int i = equalPairs.equalPairs(array);
        int i = equalPairs.equalPairs1(array);
        System.out.println(i);
    }

    public int equalPairs(int[][] grid) {
        //按列 和列遍历
        int hi = grid.length;
        Map<String, Integer> rowMap = new HashMap<String, Integer>();
        Map<String, Integer> colMap = new HashMap<String, Integer>();
        for (int i = 0; i < hi; i++) {
            StringBuilder sb = new StringBuilder("");
            StringBuilder sb1 = new StringBuilder("");
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i]);
                sb1.append(grid[i][j]);
            }
            rowMap.put(sb.toString(), rowMap.getOrDefault(sb.toString(),0) + 1);
            colMap.put(sb1.toString(), colMap.getOrDefault(sb1.toString(),0) + 1);
        }
        Integer[] count = {0};
        rowMap.forEach((k, v) -> {
            if (colMap.containsKey(k)) {
                v = Math.max(v,colMap.get(k));
                count[0] += v;
            }
        });
        return count[0];
    }

    public int equalPairs1(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }



}
