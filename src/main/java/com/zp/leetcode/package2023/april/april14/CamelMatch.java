package com.zp.leetcode.package2023.april.april14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/4/14 11:28 上午
 * 驼峰式匹配
 **/
public class CamelMatch {

    public static void main(String[] args) {



    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (String query : queries) {
            ans.add(isMatch(query, pattern));
        }
        return ans;
    }

    public Boolean isMatch(String query, String pattern) {
        int index = 0;
        for (char c : query.toCharArray()) {
            if (index == pattern.length()) {
                if (c < 'a' || c > 'z') {
                    return false;
                }
            } else {
                if (c == pattern.charAt(index)) {
                    index ++ ;
                } else if (c < 'a' || c > 'z') {
                    return false;
                }
            }
        }
        return index == pattern.length();
    }

}
