package com.zp.leetcode.package_20220416;

/**
 * @author zhengpeng
 * @date 2022-04-16 08:57
 * 合并两个有序数组
 **/
public class MergeTwoArray {


    /**
     * 新数组操作
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    @SuppressWarnings("Duplicates")
    public void mergeNew(int[] nums1, int m, int[] nums2, int n) {

        //特殊场景
        if (m == 0){
            nums1 = nums2;
            return;
        }
        if(n == 0){
            return;
        }

        int length = m + n;
        int[] result = new int[length];
        int left = 0;
        int right = 0;
        int index = 0;
        while (index < length){
            if(left < m && nums1[left] < nums2[right]){
                result[index] = nums1[left];
                left++;
                index++;
            }else {
                result[index] = nums2[right];
                right++;
                index++;
            }
        }
        //重新赋值
        nums1 = result;
        return;

    }


    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    @SuppressWarnings("Duplicates")
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //特殊场景
        if (m == 0){
            nums1 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n == 0){
            return;
        }



        int length = m + n;
        int left = 0;
        int right = 0;
        int index = 0;
        while (index < length){
            if(left < m && nums1[left] < nums2[right]){
                nums1[index] = nums1[left];
                left++;
                index++;
            }else {
                nums1[index] = nums2[right];
                right++;
                index++;
            }
        }
        //重新赋值
        return;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;


//        int[] nums1 = new int[]{1};
//        int m = 1;
//        int[] nums2 = new int[]{};
//        int n = 0;

//        int[] nums1 = new int[]{};
//        int m = 0;
//        int[] nums2 = new int[]{1};
//        int n = 1;

        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        mergeTwoArray.merge(nums1,m,nums2,n);



    }
}
