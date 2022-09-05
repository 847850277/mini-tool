package com.zp.leetcode.package2022.july.july12;

/**
 * @author zhengpeng
 * @date 2022/7/12 9:19 上午
 * 奇数单元格的数目
 **/
public class OddCells {

    public static void main(String[] args) {
        OddCells oddCells = new OddCells();
        int[][] index = new int[2][2];
        System.out.println(oddCells.oddCells(2,3,index));

    }


    public int oddCells(int m, int n, int[][] indices) {
        //初始化二维数组
        int[][] datas = new int[m][n];
        // 遍历 indices + 1
        for (int[] index : indices) {
            int line = index[0];
            int row = index[1];
            //对应行列 + 1
            int[] data = datas[line];
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i] + 1;
            }
            for (int[] ints : datas) {
                for (int i = 0; i < ints.length; i++) {
                    if(i == row){
                        ints[i] = ints[i] + 1;
                    }
                }
            }
        }
        // 遍历二维数组查找奇数
        int count = 0;
        for (int[] data : datas) {
            for (int datum : data) {
                if( (datum % 2) != 0){
                    count++;
                }
            }
        }

        return count;
    }

}
