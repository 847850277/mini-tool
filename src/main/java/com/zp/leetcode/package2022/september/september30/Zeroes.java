package com.zp.leetcode.package2022.september.september30;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/9/30 9:05 上午
 * 零矩阵
 **/
public class Zeroes {


    public static void main(String[] args) {
        Zeroes z = new Zeroes();
        //int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        z.setZeroes(matrix);
        System.out.println(matrix);
    }



    /**
     * 零矩阵
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Map<Integer,Integer> zeroRowMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> zeroColumnMap = new HashMap<Integer,Integer>();
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        //行
        for(int i = 0; i < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            //列
            for(int j = 0; j < matrix1.length; j++){
                if(matrix1[j] == 0){
                    zeroRowMap.put(i,0);
                    zeroColumnMap.put(j,0);
                }
            }
        }

        //行
        zeroRowMap.forEach((k,v) ->{

            for(int i = 0; i <columnSize;i++){
                matrix[k][i] = 0;
            }

        });

        //列
        zeroColumnMap.forEach((k,v) ->{

            for(int i = 0; i <rowSize;i++){
                matrix[i][k] = 0;
            }

        });
    }
}
