package com.zp.leetcode.package2023.february.february18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/2/18 10:30 上午
 * 找出给定方程的正整数解
 **/
public class FindSolution {

    public static void main(String[] args) {
        FindSolution findSolution = new FindSolution();

    }


    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 1; x <= 1000; x++) {
            int yleft = 1, yright = 1000;
            while (yleft <= yright) {
                int ymiddle = (yleft + yright) / 2;
                if (customfunction.f(x, ymiddle) == z) {
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(x);
                    pair.add(ymiddle);
                    res.add(pair);
                    break;
                }
                if (customfunction.f(x, ymiddle) > z) {
                    yright = ymiddle - 1;
                } else {
                    yleft = ymiddle + 1;
                }
            }
        }
        return res;
    }
}

interface CustomFunction {
    // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
    int f(int x, int y);
};