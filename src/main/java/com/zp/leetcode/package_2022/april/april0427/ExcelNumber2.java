package com.zp.leetcode.package_2022.april.april0427;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-04-25 17:52
 * Excel表列名称
 **/
public class ExcelNumber2 {

    /**
     * 以下为网上解法，简单明了
     * @param columnNumber
     * @return
     */
//    public String convertToTitle(int columnNumber) {
//        StringBuffer sb = new StringBuffer();
//        while (columnNumber > 0) {
//            int a0 = (columnNumber - 1) % 26 + 1;
//            sb.append((char)(a0 - 1 + 'A'));
//            columnNumber = (columnNumber - a0) / 26;
//        }
//        return sb.reverse().toString();
//    }

    private Map<Integer, Character> keyValueMap = new HashMap(26){{
        put(1,'A');
        put(2,'B');
        put(3,'C');
        put(4,'D');
        put(5,'E');
        put(6,'F');
        put(7,'G');
        put(8,'H');
        put(9,'I');
        put(10,'J');
        put(11,'K');
        put(12,'L');
        put(13,'M');
        put(14,'N');
        put(15,'O');
        put(16,'P');
        put(17,'Q');
        put(18,'R');
        put(19,'S');
        put(20,'T');
        put(21,'U');
        put(22,'V');
        put(23,'W');
        put(24,'X');
        put(25,'Y');
        put(26,'Z');
    }};

    private Map<Character, Integer> cMap = new HashMap(26){{
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

        int n = 1;
        int sum = 0;
        while (sum < columnNumber){
            sum += 26 * Math.pow(26,n - 1);
            n++;
        };

        //确定n的次数
        if(n == 1){
            return String.valueOf((keyValueMap.get(columnNumber)));
        }

        //n-1 就是字符串的长度数
        StringBuilder sb = new StringBuilder(n-1);
        //loop set value
        for (int i = n - 1; i > 0; i--) {
            final Character c = loopSetValue(i, columnNumber);
            columnNumber = columnNumber - (int)Math.pow(26, i -1 ) * cMap.get(c);
            sb.append(c);
        }
        return sb.toString();

    }

    private Character loopSetValue(int i, int columnNumber) {

        if(i == 1){
            return keyValueMap.get(columnNumber);
        }else {
            //确定高位
            //int index = (columnNumber - 26 ) / 26 + 1;
            int index = (columnNumber - 1 ) / (int) Math.pow(26, i -1 ) ;
            if(index == 0){
                index = 1;
            }
            return keyValueMap.get(index);
        }

        //return keyValueMap.get(1);
    }


    public static void main(String[] args) {
        ExcelNumber2 excelNumber = new ExcelNumber2();
        //System.out.println(excelNumber.convertToTitle(1));
        //System.out.println(excelNumber.convertToTitle(27));
        System.out.println(excelNumber.convertToTitle(52));
        //System.out.println(excelNumber.convertToTitle(28));
        //System.out.println(excelNumber.convertToTitle(701));
        //System.out.println(excelNumber.convertToTitle(2147483647));
        //System.out.println(excelNumber.convertToTitle(647));

    }
}
