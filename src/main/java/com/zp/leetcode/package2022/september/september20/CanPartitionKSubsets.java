package com.zp.leetcode.package2022.september.september20;

import java.util.HashMap;

/**
 * @author zhengpeng
 * @date 2022/9/20 9:14 上午
 * 划分未k个相等择子集合
 **/
public class CanPartitionKSubsets {


    // 备忘录，存储 used 的状态
    private HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        // 使用位图技巧
        int used = 0;
        int[] bucket = new int[k + 1];
        return backtrack(nums, 0, bucket, k, target, used);
    }

    private boolean backtrack(int[] nums, int start, int[] bucket, int k, int target, int used) {
        // k 个桶均装满
        if (k == 0) return true;

        // 当前桶装满了，开始装下一个桶
        if (bucket[k] == target) {
            // 注意：桶从下一个开始；球从第一个开始
            boolean res = backtrack(nums, 0, bucket, k - 1, target, used);
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            // 如果当前状态曾今计算过，就直接返回，不要再递归穷举了
            return memo.get(used);
        }

        // 第 k 个桶开始对每一个球选择进行选择是否装入
        for (int i = start; i < nums.length; i++) {
            // 如果当前球已经被装入，则跳过
            if (((used >> i) & 1) == 1) continue;
            // 如果装入当前球，桶溢出，则跳过
            if (bucket[k] + nums[i] > target) continue;

            // 装入 && 标记已使用
            bucket[k] += nums[i];
            // 将第 i 位标记为 1
            used |= 1 << i;

            // 开始判断是否选择下一个球
            // 注意：桶依旧是当前桶；球是下一个球
            // 注意：是 i + 1
            if (backtrack(nums, i + 1, bucket, k, target, used)) return true;

            // 拿出 && 标记未使用
            bucket[k] -= nums[i];
            // 将第 i 位标记为 0
            used ^= 1 << i;
        }
        // 如果所有球均不能使所有桶刚好装满
        return false;
    }

}
