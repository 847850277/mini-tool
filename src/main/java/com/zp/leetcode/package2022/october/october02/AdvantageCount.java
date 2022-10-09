package com.zp.leetcode.package2022.october.october02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author zhengpeng
 * @date 2022/10/9 9:21 上午
 * 优势洗牌 也可以叫做田忌赛马
 **/
public class AdvantageCount {

    public static void main(String[] args) {
        AdvantageCount a = new AdvantageCount();
        int[] array1 = new int[]{12,24,8,32};
        int[] array2 = new int[]{13,25,32,11};
        int[] ints = a.advantageCount(array1, array2);
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print(",");
        }


    }


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] ans = new int[len];
        Arrays.sort(nums1);
        //新增排序数组对num2进行排序
        Integer[] ids = IntStream.range(0, len).boxed().toArray(Integer[]::new);
        //num2索引排序
        Arrays.sort(ids, Comparator.comparingInt(i -> nums2[i]));
        int left = 0, right = len - 1;
        for (int i : nums1) {
            //当前值比num2对应的值大，直接赋值，否则把最小值赋值给num2对应的最大值的索引
            int num2 = nums2[ids[left]];
            if(i > num2){
                 int index = ids[left];
                 ans[index] = i;
                 left++;
            }else {
                int index = ids[right];
                ans[index] = i;
                right--;
            }
        }
        return ans;
    }

}
