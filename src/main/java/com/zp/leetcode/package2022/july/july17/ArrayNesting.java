package com.zp.leetcode.package2022.july.july17;

/**
 * @author zhengpeng
 * @date 2022/7/17 3:56 下午
 * 数组嵌套
 **/
public class ArrayNesting {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,0,3,1,6,2};
        ArrayNesting arrayNesting = new ArrayNesting();
        System.out.println(arrayNesting.arrayNesting(array));
    }


    public int arrayNesting(int[] nums) {

        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
