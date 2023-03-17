package com.zp.leetcode.package2023.march.march17;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/3/17 8:47 上午
 **/
public class AnswerQueries {

    public static void main(String[] args) {

        int[] array1 = new int[]{4,5,2,1};
        int[] array2 = new int[]{3,10,21};
        AnswerQueries answerQueries = new AnswerQueries();
        int[] ints = answerQueries.answerQueries(array1, array2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        //前缀和
        int[] f = new int[n + 1];
        for (int i = 0; i < n;i++){
            f[i+1] = f[i] + nums[i];
        }
        //二分查找
        int[] answer = new int[m];
        for (int i = 0; i < m;i++){
            answer[i] = binarySearch(f,queries[i]) - 1;
        }
        return answer;
    }

    public int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
