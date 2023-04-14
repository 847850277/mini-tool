package com.zp.leetcode.package2023.april.april14;

/**
 * @author zhengpeng
 * @date 2023/4/12 1:42 下午
 * 归并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{7,6,4,3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array,0,array.length - - 1);
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
        mergeSort(nums,m+1,r);
        merge(nums,l,m,r);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArray = new int[data.length];
        // 右数组第一个元素索引
        int midNew = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && midNew <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[midNew]) {
                tmpArray[third++] = data[left++];
            } else {
                tmpArray[third++] = data[midNew++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (midNew <= right) {
            tmpArray[third++] = data[midNew++];
        }
        while (left <= center) {
            tmpArray[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArray[tmp++];
        }
    }

}
