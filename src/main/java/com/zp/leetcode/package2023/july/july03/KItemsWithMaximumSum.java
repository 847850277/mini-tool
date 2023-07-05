package com.zp.leetcode.package2023.july.july03;

/**
 * @author zhengpeng
 * @date 2023/7/5 09:20
 * k件物品的最大和
 **/
public class KItemsWithMaximumSum {


    public static void main(String[] args) {




    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }


    public int kItemsWithMaximumSum0(int numOnes, int numZeros, int numNegOnes, int k) {
        // 都是1的情况
        if(numOnes >= k){
            return k;
        }
        int needAddOne = k - numOnes;
        // 由 1 和 0 组成的情况
        if(numZeros >= needAddOne){
            return numOnes;
        }
        // 由 1 和 0 和 - 1 组成的情况
        int needAddNegOnes =  numZeros - needAddOne;
        if(numNegOnes > needAddNegOnes){

        }
        return 0;
    }

}
