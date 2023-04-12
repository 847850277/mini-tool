package com.zp.leetcode.package2023.april.april11;

/**
 * @author zhengpeng
 * @date 2023/4/11 3:44 下午
 * 归并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        //int[] array = new int[]{7,3,2,6};
        int[] array = new int[]{7, 3, 2, 6, 0, 1, 5, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void mergeSort(int[] nums,int l,int r){
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        //合并子数组
        int[] temp = new int[r - l + 1];
        for (int k = l; k <= r; k++) {
            temp[k - l] = nums[k];
        }
        int i = 0, j = m - l + 1;
        for (int k = l; k <= r; k++) {
            if (i == m - l + 1) {
                nums[k] = temp[j++];
            } else if (j == r - l + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }

}
