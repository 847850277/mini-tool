package com.zp.leetcode.package2023.april.april17;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/4/12 1:42 下午
 * 归并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{7,6,4,3,1,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array,0,array.length-1);
        for (int i : array) {
            System.out.println(i);
        }

        //int[] array1 = new int[]{4,7};
        //int[] array2 = new int[]{3,6};
    }

    public int[] twoArraySort(int[] array1,int[] array2) {
        int len = array1.length + array2.length;
        int[] result = new int[len];
//        for (int i = 0; i < len; i++) {
//            result[i] =
//        }

        return result;
        
    }




    public void mergeSort(int[] nums,int l,int r){
        if(l >= r){
            return;
        }
        int m = (l + r) / 2;
        mergeSort(nums,l,m);
        mergeSort(nums,m + 1,r);
        merge(nums,l,m,r);
    }

    /**
     * 合并子数组
     * @param nums
     * @param l
     * @param m
     * @param r
     */
    private void merge(int[] nums, int l,int m,int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int t = 0;
        //临时数组排序
        while (i <= m && j <= r){
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }
        //临界条件
        while (i <= m){
            temp[t++] = nums[i++];
        }
        //临界条件
        while (j <= r){
            temp[t++] = nums[j++];
        }
        //排序好的赋值
        t = 0;
        while (l <= r){
            nums[l++] = temp[t++];
        }
    }


}
