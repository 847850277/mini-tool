package com.zp.leetcode.package2022.december.december22;

/**
 * @author zhengpeng
 * @date 2022/12/22 2:43 下午
 * 摆动序列
 **/
public class WiggleMaxLength {

    public static void main(String[] args) {
        int[] array = new int[]{1,7,4,9,2,5};
        WiggleMaxLength w = new WiggleMaxLength();
        System.out.println(w.wiggleMaxLength(array));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
