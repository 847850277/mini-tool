package com.zp.leetcode.package_2022.april.april0426;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-04-25 17:52
 * Excel表列序号
 **/
public class ExcelNumber {


    private Map<Character, Integer> keyValueMap = new HashMap(26){{
        put('A',1);
        put('B',2);
        put('C',3);
        put('D',4);
        put('E',5);
        put('F',6);
        put('G',7);
        put('H',8);
        put('I',9);
        put('J',10);
        put('K',11);
        put('L',12);
        put('M',13);
        put('N',14);
        put('O',15);
        put('P',16);
        put('Q',17);
        put('R',18);
        put('S',19);
        put('T',20);
        put('U',21);
        put('V',22);
        put('W',23);
        put('X',24);
        put('Y',25);
        put('Z',26);
    }};


    /**
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {

        int n = columnTitle.length();
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            //倒序取字符
            final char c = columnTitle.charAt(columnTitle.length() - i);
            sum +=  keyValueMap.get(c) * Math.pow(26, i - 1);
        }
        return sum;
    }

    /**
     * 网上解法
     */
//    public int titleToNumber(String columnTitle) {
//        int number = 0;
//        int multiple = 1;
//        for (int i = columnTitle.length() - 1; i >= 0; i--) {
//            int k = columnTitle.charAt(i) - 'A' + 1;
//            number += k * multiple;
//            multiple *= 26;
//        }
//        return number;
//    }


    public static void main(String[] args) {
        ExcelNumber excelNumber = new ExcelNumber();
        //System.out.println(excelNumber.titleToNumber("A"));
        //System.out.println(excelNumber.titleToNumber("AA"));
        //System.out.println(excelNumber.titleToNumber("AB"));
        //System.out.println(excelNumber.titleToNumber("ZY"));
        System.out.println(excelNumber.titleToNumber("ZZ"));
        System.out.println(excelNumber.titleToNumber("ZZZ"));


    }
}
