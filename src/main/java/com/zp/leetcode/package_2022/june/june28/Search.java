package com.zp.leetcode.package_2022.june.june28;

/**
 * @author zhengpeng
 * @date 2022/6/27 11:11 上午
 *  搜索旋转排序数组
 **/
public class Search {



    public int search(int[] nums, int target) {
        int length = nums.length;
        int min = nums[0];
        int max = nums[length - 1];
        int left = 0;
        int right = length - 1;
        if(target < min || target > max){
            return - 1;
        }
        //二分查找
        //int mid =
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 增加偏移量的二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int length = nums.length;
        int min = nums[0];
        int max = nums[length - 1];
        int diff = 0;
        int thePrevious = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            final int num = nums[i];
            if(num > thePrevious ){
                min = thePrevious;
                max = num;
                //循环结束
                break;
            }else{
                diff++;
                thePrevious = num;
            }
        }
        


        int left = 0;
        int right = length - 1;
        if(target < min || target > max){
            return - 1;
        }
        //二分查找
        //int mid =
        while(left < right){
            int mid = left + (right - left) / 2;
            int offsetNum = nums[mid];
            if(offsetNum == target){
                return mid;
            }else if(offsetNum < target){
                left = mid + 1;
            }else if(offsetNum > target){
                right = mid - 1;
            }
        }
        return -1;
    }




    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        Search search = new Search();
        //int[] array = new int[]{1,2,3,4,5,7,8,10};
        int[] array = new int[]{4,5,7,8,10,1,2,3};
        //int target = 9;
        //int target = 8;
        int target = 1;

        //System.out.println(search.search1(array,target));
        System.out.println(search.search2(array,target));
    }


}
