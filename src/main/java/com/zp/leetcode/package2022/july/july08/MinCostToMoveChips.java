package com.zp.leetcode.package2022.july.july08;

/**
 * @author zhengpeng
 * @date 2022/7/8 9:15 上午
 * 玩筹码
 **/
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        //移动奇数或者偶数个
        int oddNumber = 0;
        int evenNumber = 0;
        for (int i : position) {
            if((i % 2) != 0){
                oddNumber++;
            }else{
                evenNumber++;
            }
        }
        return Math.min(oddNumber,evenNumber);
    }



    public static void main(String[] args) {
        int i = 3;
        int j = 2;
        int k = 4;
        int l = 5;
        System.out.println((i&1));
        System.out.println((j&1));
        System.out.println((k&1));
        System.out.println((l&1));

        int[] array = new int[]{2,2,2,3,3};
        MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();
        System.out.println(minCostToMoveChips.minCostToMoveChips(array));
    }
}
