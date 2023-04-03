package com.zp.leetcode.package2023.april.april03;

/**
 * @author zhengpeng
 * @date 2023/4/3 2:03 下午
 * 交换一次的先前队列
 **/
public class PrevPermOpt1 {

    public static void main(String[] args) {
        //int[] array1 = new int[]{3,2,1};
        //int[] array1 = new int[]{1,1,5};
        //int[] array1 = new int[]{1,9,4,6,7};
        int[] array1 = new int[]{3,1,1,3};
        //int[] array2 = new int[]{};
        PrevPermOpt1 prevPermOpt1 = new PrevPermOpt1();
        int[] ints = prevPermOpt1.prevPermOpt1(array1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] prevPermOpt2(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        return arr;
    }

    public int[] prevPermOpt1(int[] arr) {
        int[] array = new int[arr.length];
        System.arraycopy(arr, 0,array,0, arr.length);
        int len = arr.length;
        int start = 0;
        int end = len -1;
        int endNum = array[end];
        boolean needChange = false;
        int index = 0;
        for (int i = end; i >= start; i--) {
            if(arr[i] > endNum){
                needChange = true;
                index = i;
            }
        }
        if(needChange){
            int temp = array[index];
            array[index] = endNum;
            array[end] = temp;
        }
        return array;
    }
}
