package com.zp.leetcode.package_2022.april.april0426;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-04-25 17:52
 * Excel表列名称
 **/
public class ExcelNumber2 {

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
     * 利用26的次方来反推
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {



        return "";

    }


    public static void main(String[] args) {
        ExcelNumber2 excelNumber = new ExcelNumber2();

        System.out.println(excelNumber.convertToTitle(1));
        System.out.println(excelNumber.convertToTitle(28));
        System.out.println(excelNumber.convertToTitle(701));

    }
}
