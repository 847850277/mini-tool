package com.zp.leetcode.package2022.june.june03;

import java.util.*;


/**
 * @author zhengpeng
 * @date 2022/6/3 8:29 下午
 * 二进制手表
 **/
public class ReadBinaryWatch {


    public List<String> readBinaryWatch(int turnedOn) {

        Map<String,String> keyMap = new HashMap<String,String>();
        //List<String> hours = Arrays.asList("1","2","4","8");
        //List<String> minutes = Arrays.asList("01","02","04","08","16","32");
        List<String> combines = Arrays.asList("1","2","4","8","01","02","04","08","16","32");
        //一个灯亮
        if(turnedOn == 1){
            final int size = combines.size();
            for (int i = 0; i < size; i++) {
                final String s = combines.get(i);
                if(s.length() == 1){
                    String key = s + ":00";
                    keyMap.put(key,s);
                }else if(s.length() == 2){
                    String key = "0:" + s;
                    keyMap.put(key,s);
                }
            }
        }
        if(turnedOn == 2){
            final int size = combines.size();
            for (int i = 0; i < size; i++) {
                String m = combines.get(i);
                for (int j = i + 1; j < size; j++) {
                    String s = combines.get(j);
                    if(m.length() == s.length() && s.length() == 1){
                        final int i1 = Integer.valueOf(s) + Integer.valueOf(m);
                        if(i1 != 12){
                            String key = i1 + ":00";
                            keyMap.put(key,key);
                        }
                    }else if(m.length() == s.length() && s.length() == 2){
                        final int i1 = Integer.valueOf(s) + Integer.valueOf(m);
                        if(i1 < 10){
                            String key = "0:0" + i1;
                            keyMap.put(key,key);
                        }else{
                            String key = "0:" + i1;
                            keyMap.put(key,key);
                        }

                    }else{
                        String key = m + ":" + s;
                        keyMap.put(key,key);
                    }
                }
            }
        }


        if(turnedOn == 3){
            final int size = combines.size();
            for (int i = 0; i < size; i++) {
                String iStr = combines.get(i);
                for (int j = i + 1; j < size; j++) {
                    String jStr = combines.get(j);
                    for (int k = j + 1; k < size; k++) {
                        String kStr = combines.get(k);
                        // 全部上面灯亮
                        if(iStr.length() == jStr.length() && jStr.length() == kStr.length() && iStr.length() == 1){
                            final int i1 = Integer.valueOf(iStr) + Integer.valueOf(jStr) + Integer.valueOf(kStr) ;
                            String key = "";
                            if(i1 > 12){
                                //key = (i1 - 12) + ":00";
                                continue;
                            }else{
                                key = (i1 ) + ":00";
                            }
                            keyMap.put(key,iStr + jStr + kStr);
                        // 全部下面灯亮
                        }else if(iStr.length() == jStr.length() && jStr.length() == kStr.length() && iStr.length() == 2){
                            final int i1 = Integer.valueOf(iStr) + Integer.valueOf(jStr) + Integer.valueOf(kStr) ;
                            String key = "";
                            if(i1 < 10){
                                key = "0:0" + i1;
                            }else{
                                key = "0:" + i1;
                            }
                            keyMap.put(key,iStr + jStr + kStr);
                        //上下组合
                        }else{
                            if(countLength1(iStr,jStr,kStr) == 1){
                                String[] countLength1Str = getCountStr(Arrays.asList(iStr,jStr,kStr),1,1);
                                String[] countLength2Str = getCountStr(Arrays.asList(iStr,jStr,kStr),2,2);
                                final int i1 = Integer.valueOf(countLength2Str[0]) + Integer.valueOf(countLength2Str[1]);
                                String key = "";
                                if(i1 < 10){
                                    key = countLength1Str[0] + ":0" + i1;
                                }else{
                                    key = countLength1Str[0] + ":" + i1;
                                }
                                keyMap.put(key,iStr + jStr + kStr);

                            }else if(countLength1(iStr,jStr,kStr) == 2){
                                String[] countLength1Str = getCountStr(Arrays.asList(iStr,jStr,kStr),2,1);
                                String[] countLength2Str = getCountStr(Arrays.asList(iStr,jStr,kStr),1,2);
                                final int i1 = Integer.valueOf(countLength1Str[0]) + Integer.valueOf(countLength1Str[1]);
                                String key = "";
                                if(i1 == 12){
                                    continue;
                                    //key =   "0:" + countLength2Str[0];
                                }else{
                                    key = i1 + ":" + countLength2Str[0];
                                }
                                if("0:08".equals(key)){
                                    System.out.println(key);
                                }
                                keyMap.put(key,iStr + jStr + kStr);
                            }
                        }
                    }
                }
            }
        }


        if(turnedOn == 4){
            final int size = combines.size();
            for (int i = 0; i < size; i++) {
                String iStr = combines.get(i);
                for (int j = i + 1; j < size; j++) {
                    String jStr = combines.get(j);
                    for (int k = j + 1; k < size; k++) {
                        String kStr = combines.get(k);
                        for (int l = k + 1; l < size; l++) {



                        }
                    }
                }
            }


        }






        Set<String> strings = keyMap.keySet();
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            result.add(string);
        }
        System.out.println(result.size());
        return result;


    }

    private String[] getCountStr(List<String> args, int countTimes,Integer count) {
        String[] result = new String[countTimes];
        int index = 0;
        for (String arg : args) {
            if(arg.length() == count){
                result[index] = arg;
                index++;
            }
        }
        return result;
    }

    private int countLength1(String... args) {
        int count = 0;
        for (String arg : args) {
            if(arg.length() == 1){
                count++;
            }
        }
        return count;
    }


    /**
     * 答案解法 🐂2
     * @param num
     * @return
     */
    public List<String> readBinaryWatch1(int num) {
        List<String> res = new ArrayList<>();
        //时针
        for (int i = 0; i < 12; i++) {
            //分针
            for (int j = 0; j < 60; j++) {
                int cnt = Integer.bitCount(i) + Integer.bitCount(j);
                if (cnt == num) {
                    // res.add(String.format("%d:%02d", i, j));
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(':');
                    if (j < 10) {
                        sb.append('0');
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {

        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();

        //System.out.println(readBinaryWatch.readBinaryWatch(1));
        //final List<String> strings = readBinaryWatch.readBinaryWatch(2);
        final List<String> strings = readBinaryWatch.readBinaryWatch(3);
        //String[] array = new String[]{"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
        String[] array = new String[]{"0:07","0:11","0:13","0:14","0:19","0:21","0:22","0:25","0:26","0:28","0:35","0:37","0:38","0:41","0:42","0:44","0:49","0:50","0:52","0:56","1:03","1:05","1:06","1:09","1:10","1:12","1:17","1:18","1:20","1:24","1:33","1:34","1:36","1:40","1:48","2:03","2:05","2:06","2:09","2:10","2:12","2:17","2:18","2:20","2:24","2:33","2:34","2:36","2:40","2:48","3:01","3:02","3:04","3:08","3:16","3:32","4:03","4:05","4:06","4:09","4:10","4:12","4:17","4:18","4:20","4:24","4:33","4:34","4:36","4:40","4:48","5:01","5:02","5:04","5:08","5:16","5:32","6:01","6:02","6:04","6:08","6:16","6:32","7:00","8:03","8:05","8:06","8:09","8:10","8:12","8:17","8:18","8:20","8:24","8:33","8:34","8:36","8:40","8:48","9:01","9:02","9:04","9:08","9:16","9:32","10:01","10:02","10:04","10:08","10:16","10:32","11:00"};
        System.out.println(array.length);

        for (String string : strings) {
            boolean flag = false;
            for (String s : array) {
                if(s.equals(string)){
                    flag = true;
                }
            }
            if(!flag){
                System.out.println(string);
            }
        }

        //[]
        System.out.println("================");
        for (String string : array) {
            boolean flag = false;
            for (String s : strings) {
                if(s.equals(string)){
                    flag = true;
                }
            }
            if(!flag){
                System.out.println(string);
            }
        }

    }
}
