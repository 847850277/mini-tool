package com.zp.leetcode.package_2022.june.june29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/29 10:33 上午
 * Z字变换
 **/
public class Convert {


    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String s = "afanjdskhfgaksdhfgasdfads";
        int rows = 4;
        System.out.println(convert.convert(s,rows));
    }

}
