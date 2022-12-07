package com.zp.leetcode.package2022.december.december07;

/**
 * @author zhengpeng
 * @date 2022/12/7 9:08 上午
 * 通过最小操作次数使数组的和相等
 **/
public class MinOperations {


    public static void main(String[] args) {
        int[] array1 = new int[] {1,2,3,4,5,6};
        //int[] array2 = new int[] {1,2,3,4,5,6};
        int[] array2 = new int[] {1,1,2,2,2,2};
        MinOperations m = new MinOperations();
        System.out.println(m.minOperations(array1, array2));

    }

    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        //越界情况
        if(6 * n < m || 6 * m < n){
            return -1;
        }
        //对应位置的数出现的次数
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            ++cnt1[i];
            diff += i;
        }
        for (int i : nums2) {
            ++cnt2[i];
            diff -= i;
        }
        if(diff == 0){
            return 0;
        }
        //贪心算法，局部最优解
        if(diff > 0){
            return help(cnt2,cnt1,diff);
        }
        return help(cnt1,cnt2,diff);
    }

    private int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        //？？
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }
}
