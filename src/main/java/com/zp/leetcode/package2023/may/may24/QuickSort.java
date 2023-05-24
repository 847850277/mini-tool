package com.zp.leetcode.package2023.may.may24;

/**
 * @author zhengpeng
 * @date 2023/5/24 10:05 上午
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,45,6,9,4};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortRecursive(array,0,array.length -1);
        System.out.println("success");

    }


    private void quickSortRecursive(int[] array,int start, int end) {
        //结束递归
        if(start >= end){
            return;
        }
        //轴
        int mid = array[end];
        int left = start,right = end - 1;
        while (left < right){
            if(array[left] <= mid ){
                left++;
            }
            if(array[right] >= mid && left < right){
                right--;
            }
            swap(array,left,right);
        }
        if(array[left] >= array[end]){
            swap(array,left,end);
        }else {
            left++;
        }
        quickSortRecursive(array,start,left -1);
        quickSortRecursive(array,left + 1,end);
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
