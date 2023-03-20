package com.zp.leetcode.package2023.march.march20;

/**
 * @author zhengpeng
 * @date 2023/3/20 2:58 下午
 * 找到需要补充粉笔的学生编号
 **/
public class ChalkReplacer {

    public static void main(String[] args) {
        ChalkReplacer chalkReplacer = new ChalkReplacer();
        //int[] array = new int[]{5,1,5};
        int[] array = new int[]{3,4,1,2};
        //int k = 22;
        int k = 25;
        System.out.println(chalkReplacer.chalkReplacer(array,k));
    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if(chalk[0] > k){
            return 0;
        }
        for (int i = 1; i < n; ++i) {
            chalk[i] += chalk[i - 1];
            if(chalk[i] > k){
                return i;
            }
        }
        k %= chalk[n -1];
        return binarySearch(chalk,k);
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
