package com.zp.leetcode.package2022.december.december20;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/12/20 4:02 下午
 * 袋子里最少数目的球
 **/
public class MinimumSize {

    public static void main(String[] args) {
        MinimumSize m = new MinimumSize();
        int[] array = new int[]{9};
        int maxOp = 2;
        System.out.println(m.minimumSize(array, maxOp));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1,right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for(int x: nums){
                ops += (x - 1) / y;
            }
            if(ops <= maxOperations){
                ans = y;
                right = y - 1;
            }else {
                left = y + 1;
            }
        }
        return ans;
    }
}
