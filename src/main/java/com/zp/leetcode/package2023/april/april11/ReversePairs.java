package com.zp.leetcode.package2023.april.april11;

/**
 * @author zhengpeng
 * @date 2023/4/11 11:25 上午
 * 数组中的逆序对
 **/
public class ReversePairs {


    public static void main(String[] args) {
        int[] array = new int[]{7,5,6,4};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(array));

    }



    public int reversePairs(int[] nums) {
        int len  = nums.length;
        if(len < 2){
            return 0;
        }
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        int[] temp = new int[len];
        return reversePairs(copy,0,len-1,temp);
    }

    private int reversePairs(int[] copy, int left, int right, int[] temp) {
        if(left == right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(copy, left, mid, temp);
        int rightPairs = reversePairs(copy, mid + 1, right, temp);
        if(copy[mid] <= copy[mid + 1]){
            return leftPairs + rightPairs;
        }
        int crossPair = mergeAndCount(copy,left,mid,right,temp);
        return leftPairs + rightPairs + crossPair;
    }

    private int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = copy[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                copy[k] = temp[j];
                j++;
            }else if(j == right + 1){
                copy[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                copy[k] = temp[i];
                i++;
            }else {
                copy[k] = temp[j];
                j++;
                count += (mid -i + 1);
            }
        }
        return count;
    }
}
