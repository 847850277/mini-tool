package com.zp.leetcode.package2022.november.november19;

/**
 * @author zhengpeng
 * @date 2022/11/19 10:25 上午
 * 找到最高海拔
 **/
public class LargestAltitude {

    public static void main(String[] args) {
        LargestAltitude l = new LargestAltitude();
        int[] array = new int[]{-5,1,5,0,-7};
        System.out.println(l.largestAltitude(array));
    }


    public int largestAltitude(int[] gain) {
        int[] altitudeArray = new int[gain.length + 1];
        for (int i = 1; i < altitudeArray.length; i++) {
            altitudeArray[i] = altitudeArray[i -1] + gain[i-1];
        }
        int max = Integer.MIN_VALUE;
        for (int i : altitudeArray) {
            max = Math.max(i,max);
        }
        return max;
    }
}
