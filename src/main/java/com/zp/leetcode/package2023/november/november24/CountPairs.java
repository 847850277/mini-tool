package com.zp.leetcode.package2023.november.november24;

import java.util.Arrays;
import java.util.List;

public class CountPairs {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(-1, 1, 2, 3, 1);
        List<Integer> list = Arrays.asList(-6,2,5,-2,-7,-1,3);
        //int target = 2;
        int target = -2;
        CountPairs countPairs = new CountPairs();
        System.out.println(countPairs.countPairs(list,target));
    }

    public int countPairs(List<Integer> nums, int target) {
        int len = nums.size();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums.get(i) + nums.get(j);
                if(sum < target){
                    ans++;
                }
            }
        }
        return ans;
    }
}
