package com.zp.leetcode.package2023.september.september11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleCourse {

    public static void main(String[] args) {
        int[][] array = new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}};
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        System.out.println(scheduleCourse.scheduleCourse(array));
    }


    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> b -a);
        // 优先队列中所有课程的总时间
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if(total + ti <= di){
                total += ti;
                q.offer(ti);
            }else if(!q.isEmpty() && q.peek() > ti){
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }
        return q.size();
    }

}
