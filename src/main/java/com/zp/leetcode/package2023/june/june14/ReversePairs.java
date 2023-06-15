package com.zp.leetcode.package2023.june.june14;

/**
 * @author zhengpeng
 * @date 2023/4/19 3:38 下午
 * 数组中的逆序对数量
 **/
public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        //int[] array = new int[]{1,1,1,3,5};
        //int[] array = new int[]{1,1,1,2,3,5,9,9};
        //int[] array = new int[]{0,6,7,8,9,10,13,15};
        //int target = 1;
        int target = 9;
        //System.out.println(reversePairs.binarySearchSum(array,target));
        //int[] array = new int[]{7,5,6,4};
        //int[] array = new int[]{13,8,10,6,15,18,12,20,9,14,17,19};
        int[] array = new int[]{1,1,1,1,1};
        //int[] array = new int[]{1,3,2,3,1};
        //int[] array = new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        //int[] array = new int[]{13,8,10,6,15,18,12};
        //int[] array = new int[]{15,18,12};
        //int[] array = new int[]{13,8,10,6,15,18,12,20,9};
        //int[] array = new int[]{1,1,1,1,1};
        //int[] array = new int[]{18,12,20,9};
        System.out.println(reversePairs.reversePairs_0(array));
        System.out.println(reversePairs.reversePairs(array));
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
        if(nums.length == 0){
            return 0;
        }
        return reversePairs(nums,0,nums.length - 1);
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
            sum += binarySearch(leftArray,i);
        }
        return sum;
    }


    /**
     * 可查找重复元素的二分查找算法
     * 思路：
     *  1、先定义两个下标 ， left = 0 , right = arr.length -1;
     *  2、因为我们也不知道要循环多少次，定义一个while循环，终止条件为right>left
     *  3、因为是二分查找，定义一个mid = left + (right - left) / 2;防止数据过大溢出
     *  4、定义三个if语句，如果 target == arr[mid], return mid;这是经典的二分查找，我们需要在这做改进
     *  4.1、改进经典二分算法，因为可能有重复元素，我们需要返回第一个出现target的下标；因为我们也不知道mid前面有几个重复的元素
     * 因此我们需要一个while(mid>=0)的循环，mid--,然后比对arr[mid]和target，只要不一样就终止，返回
     *  5、如果 target < arr[mid] , right = mid - 1;
     *  6、如果target > arr[mid] , left = mid + 1;
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums , int target){

        int left = 0;
        int right = nums.length - 1;

        if(target > nums[right]){
            return 0;
        }
        if(target < nums[left]){
            return nums.length;
        }

        while(left <= right ) {
            int mid = (left + (right - left) / 2);
            if( target == nums[mid] ) {
                //左边的临界条件
                while(mid >= 0) {
                    if(nums[mid] != target) {
                        break;
                    }
                    mid--;
                }
                if(mid <= -1 ) {
                    int currentIndexValue = nums[0];
                    int nextValueIndex = 0;
                    while (currentIndexValue == nums[nextValueIndex] && nextValueIndex < (nums.length -1)){
                        nextValueIndex++;
                    }
                    if(nextValueIndex == 0){
                        return 0;
                    }
                    if(nums[nextValueIndex] == nums[0]){
                        return 0;
                    }
                    return nums.length - nextValueIndex;
                }
                //右边的临界条件
                //多减了一次，返回的时候需要再加1
                int index =  mid + 1;
                while(index <= nums.length - 1) {
                    if(nums[index] != target) {
                        break;
                    }
                    index++;
                }
                return nums.length - index;
            }else if( target < nums[mid] ) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        //没有查找到满足条件target的数据，返回满足条件的数组长度
        return (nums.length - left);

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


    /**
     *
     * @param arr
     * @param target
     * @return
     */
    public int binarySearchLength(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        if(target > arr[high]){
            return 0;
        }
        if(target < arr[low]){
            return arr.length;
        }

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                int temp = mid;
                while (arr[temp] == target){
                    if(arr[temp] == target && temp != 0){
                        temp = temp-1;
                    }
                    if(temp <= 0){
                        return 0;
                    }
                    if(temp >= mid && arr[temp] == target){
                        temp = temp+1;
                    }
                    if(temp == arr.length){
                        return arr.length;
                    }
                }
                return (temp + 1);
            }else if(arr[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return (arr.length - low);
    }

}
