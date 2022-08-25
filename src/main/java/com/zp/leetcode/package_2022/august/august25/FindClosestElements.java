package com.zp.leetcode.package_2022.august.august25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/8/25 10:25 上午
 * 找到K个最接近的元素
 **/
public class FindClosestElements {

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,5};
        int[] array = new int[]{1,1,1,10,10,10};
        //int k = 4;
        int k = 1;
        //int x = 3;
        int x = 9;

        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(array, k, x));
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int number = k;
        int index = 0;
        for (int i : arr) {
            if(i > x){
                index = -1;
                break;
            }
            if(i == x){
                break;
            }
            index++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(index < 0){
            for(int i = 0;i<k;i++){
                result.add(arr[i]);
            }
            return result;
        }else {
            int left = index;
            int right = index;
            while (number != 0 ){
                if(number != 0 && left != 0){
                    left--;
                    number--;
                }
                if(number != 0){
                    right++;
                    number--;
                }
            }
            for (int i = left; i < right; i++) {
                result.add(arr[i]);
            }

        }
        return result;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= x) l = mid;
            else r = mid - 1;
        }
        r = r + 1 < n && Math.abs(arr[r + 1] - x) < Math.abs(arr[r] - x) ? r + 1 : r;
        int i = r - 1, j = r + 1;
        while (j - i - 1 < k) {
            if (i >= 0 && j < n) {
                if (Math.abs(arr[j] - x) < Math.abs(arr[i] - x)) j++;
                else i--;
            } else if (i >= 0) {
                i--;
            } else {
                j++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int p = i + 1; p <= j - 1; p++) ans.add(arr[p]);
        return ans;
    }

}
