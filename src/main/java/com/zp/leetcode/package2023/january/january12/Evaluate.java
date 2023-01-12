package com.zp.leetcode.package2023.january.january12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/1/12 2:11 下午
 * 替换字符串中的括号内容
 **/
public class Evaluate {

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> list1 = new ArrayList<>(); 
        List<String> list2 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        list2.add("age");
        list2.add("two");
        Evaluate evaluate = new Evaluate();
        knowledge.add(list1);
        knowledge.add(list2);
        System.out.println(evaluate.evaluate(s,knowledge));

    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }


}
