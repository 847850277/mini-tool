package com.zp.leetcode.package2023.may.may02;

/**
 * @author zhengpeng
 * @date 2023/4/19 3:38 下午
 * 数组中的逆序对数量
 **/
public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] array = new int[]{1,1,1,3,5};
        //int[] array = new int[]{0,6,7,8,9,10,13,15};
        int target = 1;
        System.out.println(reversePairs.binarySearchSum(array,target));
        //int[] array = new int[]{7,5,6,4};
        //int[] array = new int[]{13,8,10,6,15,18,12,20,9,14,17,19};
        //int[] array = new int[]{13,8,10,6,15,18,12};
        //int[] array = new int[]{15,18,12};
        //int[] array = new int[]{13,8,10,6,15,18,12,20,9};
        //int[] array = new int[]{1,1,1,1,1};
        //int[] array = new int[]{18,12,20,9};
        //System.out.println(reversePairs.reversePairs_0(array));
        //System.out.println(reversePairs.reversePairs(array));
    }

    /**
     * 两层循环
     * @param nums
     * @return
     */
    public int reversePairs_0(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]){
                    sum++;
                }
            }
        }
        return sum;
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
    private int binarySearch(int[] leftArray, int[] rightArray) {
        int sum = 0;
        for (int i : rightArray) {
            sum += binarySearchSum(leftArray,i);
        }
        return sum;
    }

    public int binarySearchSum(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        if(target > arr[high]){
            return 0;
        }
        if(target < arr[low]){
            return arr.length;
        }
        if( low > high){
            return 0;
        }

        //首尾相加再除以2得出中间索引
        int mid = (low + high) / 2;
        //TODO 处理值相等的情况，target的值在数组中存在
        while (low<=high) { //确保程序不会重复查询，不会越界
            if (target > arr[mid]) {
                //如果查询的值比中间值大，则往右边区域找，就把最小索引改为中间索引右移一位
                low = mid + 1;
            } else if (target < arr[mid]) {
                //如果查询的值比中间值小，则往左边区域找，就把最大索引改为中间索引左移一位
                high = mid - 1;
            } else {
                //剩余的情况就是查询到了结果，那么就直接返回索引。
                //if(mid == (arr.length -1)){
                //    return 0;
                //}else if(mid + 1)
                return (arr.length - 1 - mid);
            }
            mid = (low + high) / 2;
        }
        //没有查询到，则返回-1
        return (arr.length - 1 - mid);

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
