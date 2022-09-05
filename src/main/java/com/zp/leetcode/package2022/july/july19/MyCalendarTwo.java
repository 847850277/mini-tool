package com.zp.leetcode.package2022.july.july19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/7/19 10:37 上午
 * 我的日程安排表II
 **/
public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        int[] array1 = new int[]{10,20};
        int[] array2 = new int[]{50,60};
        int[] array3 = new int[]{10,40};
        int[] array4 = new int[]{5,15};
        int[] array5 = new int[]{5,10};
        int[] array6 = new int[]{25,55};

        System.out.println(myCalendarTwo.book(array1[0],array1[1]));
        System.out.println(myCalendarTwo.book(array2[0],array2[1]));
        System.out.println(myCalendarTwo.book(array3[0],array3[1]));
        System.out.println(myCalendarTwo.book(array4[0],array4[1]));
        System.out.println(myCalendarTwo.book(array5[0],array5[1]));
        System.out.println(myCalendarTwo.book(array6[0],array6[1]));

    }


    List<int[]> booked;
    List<int[]> booked1;

    public MyCalendarTwo() {
        booked = new ArrayList<int[]>();
        booked1 = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {

        for (int[] arr : booked1) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                booked1.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;

    }
}
