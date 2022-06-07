package com.zp.leetcode.package_2022.june.june07;

/**
 * @author zhengpeng
 * @date 2022/6/7 9:33 上午
 * 爱吃香蕉的珂珂
 **/
public class MinEatingSpeed {


    public int minEatingSpeed(int[] piles, int h) {
        int minValue = Integer.MIN_VALUE;
        int size = piles.length;
        long sum = 0L;
        for (int pile : piles) {
            minValue = Math.max(pile, minValue);
            sum += pile;
        }
        if(h == size){
            return minValue;
        }
        // 二分查找法？
        if(h > size){

        }


        return 0;
    }



    public int minEatingSpeed1(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        int[] array = new int[]{1,2,3};
        int h = 4;
        System.out.println(minEatingSpeed.minEatingSpeed1(array,5));

    }


}
