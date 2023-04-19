package com.zp.leetcode.package2023.april.april19;

/**
 * @author zhengpeng
 * @date 2023/4/19 3:38 下午
 * 数组中的逆序对数量
 **/
public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        //int[] array = new int[]{0,6,7,8,9,10,13,15};
        //int target = 9;
        //System.out.println(reversePairs.binarySearchSum(array,target));
        //int[] array = new int[]{7,5,6,4};
        int[] array = new int[]{13,8,10,6,15,18,12,20,9,14,17,19};
        System.out.println(reversePairs.reversePairs(array));


    }


    /**
     * 分治法 N logN 平方的算法
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return reversePairs(nums,0,nums.length - 1);
        //return 0;
    }

    private int reversePairs(int[] nums, int left, int right) {
        if(left == right){
            return 0;
        }
        int mid = (left + right) / 2;
        int leftSum = reversePairs(nums,left,mid);
        int rightSum = reversePairs(nums,mid + 1,right);
        int crossSum = crossFind(nums,left,mid,right);
        return leftSum + rightSum + crossSum;
    }

    /**
     * 合并查找 、先归并排序，然后再二分查找
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int crossFind(int[] nums, int left, int mid, int right) {

        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        int i = left;
        while (i <= mid){
            leftArray[i - left] = nums[i];
            i++;
        }

        int j = mid + 1;
        while (j <= right){
            rightArray[j - (mid + 1)] = nums[j];
            j++;
        }

        // 归并排序
        mergeSort(leftArray,0,leftArray.length - 1);
        mergeSort(rightArray,0,rightArray.length - 1);
        //return binarySearch(rightArray,leftArray);
        return binarySearch(leftArray,rightArray);
    }

    /**
     *
     * @param rightArray
     * @param leftArray
     * @return
     */
    private int binarySearch(int[] rightArray, int[] leftArray) {
        int sum = 0;
        for (int i : rightArray) {
            sum += binarySearchSum(leftArray,i);
        }
        return sum;
    }

    public int binarySearchSum(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        //定义middle
        int middle = 0;

        if(target > arr[high]){
            return arr.length;
        }
        if(target < arr[low]){
            return 0;
        }
        if( low > high){
            return 0;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > target){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < target){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }
        //最后仍然没有找到，则返回-1
        return middle;
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
