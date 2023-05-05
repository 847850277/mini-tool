package com.zp.leetcode.package2023.may.may02;

/**
 * @author zhengpeng
 * @date 2023/5/5 9:06 上午
 * 处理用时最长的那个任务的员工
 **/
public class HardestWorker {


    public static void main(String[] args) {


        //int[][] array = new int[][]{{0,3},{2,5},{0,9},{1,15}};
        //int[][] array = new int[][]{{1,1},{3,7},{2,12},{7,17}};
        int[][] array = new int[][]{{36,3},{1,5},{12,8},{25,9},{53,11},{29,12},{52,14}};
        //int n = 10;
        int n = 70;
        HardestWorker hardestWorker = new HardestWorker();
        System.out.println(hardestWorker.hardestWorker(n,array));

    }


    public int hardestWorker(int n, int[][] logs) {
        int index = 0;
        Integer maxDiff = Integer.MIN_VALUE;
        for (int[] log : logs) {
            int diff = log[1] - index;
            index = log[1];
            log[1] = diff;
            maxDiff = Math.max(maxDiff,diff);
        }
        Integer minIndex = Integer.MAX_VALUE;
        for (int[] log : logs) {
            if(log[1] == maxDiff){
                minIndex = Math.min(log[0],minIndex);
            }
        }
        return minIndex;
    }

}
