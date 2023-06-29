package com.zp.leetcode.package2023.june.june29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/6/29 09:49
 * 重构2行二进制矩阵
 **/
public class ReconstructMatrix {


    public static void main(String[] args) {

    }


    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int sum = 0 , two = 0;
        for (int i = 0; i < n; i++) {
            if(colsum[i] == 2){
                ++two;
            }
            sum += colsum[i];
        }
        if(sum != upper + lower || Math.min(upper,lower) < two){
            return new ArrayList<List<Integer>>();
        }
        upper -= two;
        lower -= two;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
            } else if (colsum[i] == 1) {
                if (upper > 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    --upper;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                }
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }


}
