package com.zp.leetcode.package2023.may.may25;

/**
 * @author zhengpeng
 * @date 2023/5/25 2:05 下午
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,8,1,5,7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortRecursive(array,0,array.length -1);
        System.out.println("success");
    }




    public void swap(int[] array,int left,int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }



    public void quickSortRecursive(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        //轴
        int mid = array[end];
        int left = start,right = end - 1;
        while (left < right){
            //左移动1
            while (array[left] <= mid && left < right) {
                left++;
            }
            //右移动
            while (array[right] >= mid && left < right) {
                right--;
            }
            //交换？
            swap(array,left,right);
        }


        // 一轮划分后，针对轴数据的处理
        if(array[left] >= array[end]){
            swap(array,left,end);
        }else {
            left++;
        }

        //分
        quickSortRecursive(array,start,left -1);

        //分
        quickSortRecursive(array,left + 1,end);

    }







}
