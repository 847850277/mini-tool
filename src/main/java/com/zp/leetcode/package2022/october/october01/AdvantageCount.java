package com.zp.leetcode.package2022.october.october01;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author zhengpeng
 * @date 2022/10/8 9:09 上午
 * 优势洗牌 也可以叫做 "田忌赛马"
 * 把num1当成田忌的马，把num2当成齐威王的马
 *  - 如果他能比过齐威王的下等马（num2的最小值），这一分直接拿下
 *  - 如果它比不过齐威王的下等马，则用田忌的下等马比齐威王的上等马（num2的最大值）
 * 去掉这两匹马，问题变成规模更小的（n-1）的子问题，重复以上过程，即得到了所有马的对应关系
 **/
public class AdvantageCount {


    public static void main(String[] args) {

        //int[] array1 = new int[]{2,7,11,15};
        //int[] array2 = new int[]{1,10,4,11};

        int[] array1 = new int[]{12,24,8,32};
        int[] array2 = new int[]{13,25,32,11};

        AdvantageCount a = new AdvantageCount();
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
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        //num2索引排序
        Arrays.sort(ids, Comparator.comparingInt(i -> nums2[i]));
        //左右指针
        int left = 0, right = n - 1;
        for (int x : nums1){
            /**
             *  - 如果他能比过齐威王的下等马（num2的最小值），这一分直接拿下
             *  - 如果它比不过齐威王的下等马，则用田忌的下等马比齐威王的上等马（num2的最大值）
              */
            Integer index = x > nums2[ids[left]] ? ids[left++] : ids[right--];
            ans[index] = x;
        }
        return ans;
    }
}
