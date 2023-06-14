package com.zp.leetcode.package2023.june.june14;

/**
 * @author zhengpeng
 * @date 2023/6/14 14:58
 * 二分法查找满足条件数组的长度
 **/
public class BinarySearchLength {


    public static void main(String[] args) {

        int[] arrays = new int[]{-2147483647,-2147483647,-2147483647,2147483647,2147483647,2147483647};
        int target = 2147483647;
        BinarySearchLength binarySearchLength = new BinarySearchLength();
        System.out.println(binarySearchLength.binarySearchLength(arrays,target));
    }


    public int binarySearchLength(int[] arr, int target) {
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            while (arr[mid] == target){
                int temp = mid;
                if(temp == 0){
                    return 0;
                }



            }


        }

        return (arr.length - low);
    }

}
