package com.zp.leetcode.package_2022.june.june15;

/**
 * @author zhengpeng
 * @date 2022/6/14 5:13 下午
 * 排列硬币
 **/
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        // 1,2,3,4,5
        // 到第 k 行时的总硬币数等于 k(k+1)/2
        // 只要找到最接近 n 的那个 k 就可以了
        // 所以，我们可以使用二分查找
        long left = 1, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long total = mid * (mid + 1) / 2;
            if (total == n) {
                return (int) mid;
            }
            if (total > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) right;
    }


    public static void main(String[] args) {

    }

}
