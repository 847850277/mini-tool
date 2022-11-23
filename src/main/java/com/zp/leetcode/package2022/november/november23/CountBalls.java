package com.zp.leetcode.package2022.november.november23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/11/23 9:15 上午
 * 盒子中小球的最大数量
 **/
public class CountBalls {


    public static void main(String[] args) {
        CountBalls c = new CountBalls();
        int low = 1;
        int high = 10;
        System.out.println(c.countBalls(low,high));

    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0, x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            count.put(box, count.getOrDefault(box, 0) + 1);
            res = Math.max(res, count.get(box));
        }
        return res;
    }


}
