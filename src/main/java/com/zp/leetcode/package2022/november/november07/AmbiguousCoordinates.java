package com.zp.leetcode.package2022.november.november07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/11/7 9:32 上午
 * 模糊坐标
 **/
public class AmbiguousCoordinates {


    public static void main(String[] args) {

        String s = "(123)";
        AmbiguousCoordinates ambiguousCoordinates = new AmbiguousCoordinates();
        System.out.println(ambiguousCoordinates.ambiguousCoordinates(s));
    }


    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 2; i <= n - 2; i++) {
            List<String> left = backtracking(s.substring(1,i));
            List<String> right = backtracking(s.substring(i,n-1));
            for (String s1 : left) {
                for (String s2 : right) {
                    //res.add('(' + s1 + "," + s2 + ')');
                    res.add('(' + s1 + ", " + s2 + ')');
                }
            }
        }

        return res;
    }

    private List<String> backtracking(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        if (s.length() == 1) {
            res.add(s);
            return res;
        }

        if (s.charAt(0) == '0' && s.charAt(n - 1) == '0') return res;

        if (s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }

        if (s.charAt(n - 1) == '0') {
            res.add(s);
            return res;
        }

        res.add(s);
        for (int i = 1; i < n; i++) {
            res.add(s.substring(0, i) + '.' + s.substring(i, n));
        }
        return res;
    }


}
