package com.zp.leetcode.package2023.june.june19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/6/19 09:12
 * 可被3整除的最大和
 **/
public class MaxSumDivThree {

    public static void main(String[] args) {

        int[] array = new int[]{3,6,5,1,8};
        MaxSumDivThree maxSumDivThree = new MaxSumDivThree();
        System.out.println(maxSumDivThree.maxSumDivThree(array));

    }

    public int maxSumDivThree(int[] nums) {
        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; ++i) {
            v[i] = new ArrayList<Integer>();
        }
        for (int num : nums) {
            v[num % 3].add(num);
        }
        Collections.sort(v[1], (a, b) -> b - a);
        Collections.sort(v[2], (a, b) -> b - a);

        int ans = 0;
        int lb = v[1].size(), lc = v[2].size();
        for (int cntb = lb - 2; cntb <= lb; ++cntb) {
            if (cntb >= 0) {
                for (int cntc = lc - 2; cntc <= lc; ++cntc) {
                    if (cntc >= 0 && (cntb - cntc) % 3 == 0) {
                        ans = Math.max(ans, getSum(v[1], 0, cntb) + getSum(v[2], 0, cntc));
                    }
                }
            }
        }
        return ans + getSum(v[0], 0, v[0].size());
    }

    public int getSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += list.get(i);
        }
        return sum;
    }

}
