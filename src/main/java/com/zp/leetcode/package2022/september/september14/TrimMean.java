package com.zp.leetcode.package2022.september.september14;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/9/14 4:17 下午
 * 删除某些元素后的数组均值
 **/
public class TrimMean {


    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = 0;
        for (int i = n / 20; i < n - n / 20; i++){
            tot += arr[i];
        }
        return tot * 1.0 / (n * 0.9);
    }

}
