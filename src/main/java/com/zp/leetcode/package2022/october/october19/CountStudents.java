package com.zp.leetcode.package2022.october.october19;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/10/19 9:16 上午
 * 无法吃午餐的学生数量
 **/
public class CountStudents {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(CollectionUtil.isNotEmpty(list));

        int[] arrays0 = new int[]{1,1,1,0,0,1};
        int[] arrays1 = new int[]{1,0,0,0,1,1};
        CountStudents countStudents = new CountStudents();
        System.out.println(countStudents.countStudents(arrays0,arrays1));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int num : students) {
            counts[num] += 1;
        }
        int n = sandwiches.length;
        for (int i = 0; i < n; i++) {
            if (counts[sandwiches[i]] > 0) {
                counts[sandwiches[i]] -= 1;
            } else {
                return n - i;
            }
        }
        return 0;
    }

}
