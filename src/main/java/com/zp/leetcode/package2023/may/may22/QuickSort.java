package com.zp.leetcode.package2023.may.may22;

/**
 * @author zhengpeng
 * @date 2023/5/22 9:20 上午
 * 快速排序
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,45,6,3,4,7658,345,65,0,7,84,5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.println("success");
    }


    int[] arr;

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void quickSortRecursive(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right) {
                left++;
            }
            while (arr[right] >= mid && left < right) {
                right--;
            }
            swap(left, right);
        }
        if (arr[left] >= arr[end]) {
            swap(left, end);
        } else {
            left++;
        }
        quickSortRecursive(start, left - 1);
        quickSortRecursive(left + 1, end);
    }

    public void sort(int[] array) {
        arr = array;
        quickSortRecursive(0, arr.length - 1);
    }


}
