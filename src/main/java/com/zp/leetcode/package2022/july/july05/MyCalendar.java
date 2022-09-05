package com.zp.leetcode.package2022.july.july05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/7/5 2:33 下午
 * 我的日程安排表
 **/
public class MyCalendar {
    private List<List<Integer>> datas;

    public MyCalendar() {
        datas = new ArrayList<List<Integer>>();
    }

    public boolean book(int start, int end) {
       if(datas.size() == 0){
           List<Integer> items = new ArrayList<>();
           items.add(start);
           items.add(end);
           datas.add(items);
           return true;
       }
       for (List<Integer> data : datas) {
           int left = data.get(0);
           int right = data.get(1);
           if(left < end && start < right){
               return false;
           }
       }
        List<Integer> items = new ArrayList<>();
        items.add(start);
        items.add(end);
        datas.add(items);
        return true;
    }



    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        //System.out.println(myCalendar.book(10,20));
        //System.out.println(myCalendar.book(15,25));
        /**
         * [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
         * 				测试结果:[null,true,true,false,false,true,false,true,true,true,true]
         * 				期望结果:[null,true,true,false,false,true,false,true,true,true,false]
         */

        //System.out.println(myCalendar.book(20,30));
//        System.out.println(myCalendar.book(47,50));
//        System.out.println(myCalendar.book(33,41));
//        System.out.println(myCalendar.book(39,45));
//        System.out.println(myCalendar.book(33,42));
//        System.out.println(myCalendar.book(25,32));
//        System.out.println(myCalendar.book(26,35));
//        System.out.println(myCalendar.book(19,25));
//        System.out.println(myCalendar.book(3,8));
//        System.out.println(myCalendar.book(8,13));
//        System.out.println(myCalendar.book(18,27));

        /*
        测试用例:["MyCalendar","book","book","book","book","book"]
				[[],[37,50],[33,50],[4,17],[35,48],[8,25]]
        测试结果:[null,true,true,true,false,false]
        期望结果:[null,true,false,true,false,false]
        stdout:
         */
        System.out.println(myCalendar.book(37,50));
        System.out.println(myCalendar.book(33,50));


    }

}

class MyCalendar1 {
    List<int[]> booked;

    public MyCalendar1() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
