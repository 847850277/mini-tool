package com.zp.leetcode.package2022.october.october01;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zhengpeng
 * @date 2022/10/8 9:09 上午
 * 优势洗牌
 **/
public class AdvantageCount {


    public static void main(String[] args) {
        int[] array1 = new int[]{2,7,11,15};
        int[] array2 = new int[]{1,10,4,11};

        AdvantageCount a = new AdvantageCount();
        int[] ints = a.advantageCount(array1, array2);
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print(",");
        }

    }


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
        //num2索引排序
        Arrays.sort(ids, (i, j) -> nums2[i] - nums2[j]);
        int left = 0, right = n - 1;
        for (int x : nums1){
            //选择num1元素赋值到索引位置
            ans[x > nums2[ids[left]] ? ids[left++] : ids[right--]] = x;
        }
        return ans;
    }
}
