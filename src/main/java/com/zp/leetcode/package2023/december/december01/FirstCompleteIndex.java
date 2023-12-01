package com.zp.leetcode.package2023.december.december01;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出叠涂元素
 */
public class FirstCompleteIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2};
        int[][] mat = new int[][]{{1,4},{2,3}};
        FirstCompleteIndex firstCompleteIndex = new FirstCompleteIndex();
        System.out.println(firstCompleteIndex.firstCompleteIndex(arr,mat));
    }


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for (int i = 0; i < arr.length; i++) {
            int[] v = map.get(arr[i]);
            rowCnt[v[0]]++;
            if(rowCnt[v[0]] == m){
                return i;
            }
            colCnt[v[1]]++;
            if(colCnt[v[1]] == n){
                return i;
            }
        }
        return -1;
    }
}
