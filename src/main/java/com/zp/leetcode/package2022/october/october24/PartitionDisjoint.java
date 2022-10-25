package com.zp.leetcode.package2022.october.october24;

/**
 * @author zhengpeng
 * @date 2022/10/24 9:55 上午
 * 分割数组
 **/
public class PartitionDisjoint {

    public static void main(String[] args) {
        int[] nums = new int[]{5,0,3,8,6};
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        System.out.println(partitionDisjoint.partitionDisjoint(nums));
    }


    /**
     * 分割数组
     * 从右往左循环，依次找能满足的最小值
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        //这个循环干嘛？
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        int maxLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return n - 1;
    }

}
