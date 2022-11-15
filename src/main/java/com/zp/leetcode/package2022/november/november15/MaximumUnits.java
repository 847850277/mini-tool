package com.zp.leetcode.package2022.november.november15;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/11/15 1:48 下午
 **/
public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (numberOfBoxes < truckSize) {
                res += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                res += truckSize * numberOfUnitsPerBox;
                break;
            }
        }
        return res;
    }

}
