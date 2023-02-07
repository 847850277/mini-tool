package com.zp.leetcode.package2023.february.february07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2023/2/7 9:15 上午
 * 警告员工
 **/
public class AlertNames {

    public static void main(String[] args) {



    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<String>> timeMap = new HashMap<>();
        timeMap.put("00",new ArrayList<String>(Arrays.asList("00:00","01:00")));
        timeMap.put("01",new ArrayList<String>(Arrays.asList("01:00","02:00")));
        timeMap.put("02",new ArrayList<String>(Arrays.asList("02:00","03:00")));
        timeMap.put("03",new ArrayList<String>(Arrays.asList("03:00","04:00")));
        timeMap.put("04",new ArrayList<String>(Arrays.asList("04:00","05:00")));
        timeMap.put("05",new ArrayList<String>(Arrays.asList("05:00","06:00")));
        timeMap.put("06",new ArrayList<String>(Arrays.asList("06:00","07:00")));
        timeMap.put("07",new ArrayList<String>(Arrays.asList("07:00","08:00")));
        timeMap.put("08",new ArrayList<String>(Arrays.asList("08:00","09:00")));
        timeMap.put("09",new ArrayList<String>(Arrays.asList("09:00","10:00")));
        timeMap.put("10",new ArrayList<String>(Arrays.asList("10:00","11:00")));
        timeMap.put("11",new ArrayList<String>(Arrays.asList("11:00","12:00")));
        timeMap.put("12",new ArrayList<String>(Arrays.asList("12:00","13:00")));
        timeMap.put("13",new ArrayList<String>(Arrays.asList("13:00","14:00")));
        timeMap.put("14",new ArrayList<String>(Arrays.asList("14:00","15:00")));
        timeMap.put("15",new ArrayList<String>(Arrays.asList("15:00","16:00")));
        timeMap.put("16",new ArrayList<String>(Arrays.asList("16:00","17:00")));
        timeMap.put("17",new ArrayList<String>(Arrays.asList("17:00","18:00")));
        timeMap.put("18",new ArrayList<String>(Arrays.asList("18:00","19:00")));
        timeMap.put("19",new ArrayList<String>(Arrays.asList("19:00","20:00")));
        timeMap.put("20",new ArrayList<String>(Arrays.asList("20:00","21:00")));
        timeMap.put("21",new ArrayList<String>(Arrays.asList("21:00","22:00")));
        timeMap.put("22",new ArrayList<String>(Arrays.asList("22:00","23:00")));
        timeMap.put("23",new ArrayList<String>(Arrays.asList("23:00","24:00")));
        timeMap.put("24",new ArrayList<String>(Arrays.asList("24:00","00:00")));

        Map<String,List<String>> userClockMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String userName = keyName[i];
            List<String> orDefault = userClockMap.getOrDefault(userName, new ArrayList<>());
            orDefault.add(keyTime[i]);
            userClockMap.put(userName,orDefault);
        }

        userClockMap.forEach((k,v) ->{



        });

        return null;
    }

    public List<String> alertNames1(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<String>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
