package com.zp.leetcode.package2022.october.october01;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zhengpeng
 * @date 2022/10/8 9:09 上午
 * 优势洗牌
 **/
public class AdvantageCount {

    /**
     * 田忌赛马
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (i, j) -> nums2[i] - nums2[j]);
        int left = 0, right = n - 1;
        for (int x : nums1){
            ans[x > nums2[ids[left]] ? ids[left++] : ids[right--]] = x;
        }
        return ans;
    }
}
