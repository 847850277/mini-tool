package com.zp.leetcode.package_2022.june.june04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/4 8:05 下午
 * 独特的电子邮件地址
 **/
public class NumUniqueEmails {


    public int numUniqueEmails(String[] emails) {
        Map<String,String> maps = new HashMap<String,String>();
        for (String email : emails) {
            String[] split = email.split("@");
            StringBuilder start = new StringBuilder();
            String s = split[0];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '+'){
                    //跳出循环
                    break;
                }
                if(c != '.'){
                    start.append(c);
                }

            }
            String end = split[1];
            if(start.length() != 0){
                String emailKey = start.toString() + "@"  + end;
                maps.put(emailKey,emailKey);
            }
        }
        return maps.keySet().size();

    }

    public static void main(String[] args) {
        NumUniqueEmails numUniqueEmails = new NumUniqueEmails();
        //String[] array = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        //String[] array = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String[] array = new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails.numUniqueEmails(array));
    }
}
