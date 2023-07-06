package com.zp.leetcode.package2023.july.july06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/7/6 15:46
 * 拆分成最多数目的正偶数之和
 **/
public class MaximumEvenSplit {


    public static void main(String[] args) {

    }


    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }

}
