package com.zp.leetcode.package_2022.june.june07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/7 2:31 下午
 **/
public class Permute1 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        backtrack(nums, path);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果path中已有，则跳过
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}
