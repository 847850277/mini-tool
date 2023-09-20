package com.zp.leetcode.package2023.september.september19;

import java.util.Arrays;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 打家劫舍
 */
public class MinCapability {

    public static void main(String[] args) {
        System.out.println(SECONDS.toMillis(1));
        Boolean a = Boolean.valueOf("false");
        System.out.println(a  == false);
    }


    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }
}
