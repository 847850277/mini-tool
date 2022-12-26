package com.zp.leetcode.package2022.december.december26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/12/26 9:17 上午
 **/
public class CountHomogenous {


    public static void main(String[] args) {

        //String s = "abbccc";
        //String s = "abbcccaa";
        String s = "b";
        //String s = "zzzzz";
        //String s = "xy";
        //String s = "abccd";
        CountHomogenous c = new CountHomogenous();
        //System.out.println(c.count(s));
        System.out.println(c.countHomogenous(s));
        //System.out.println(countSize);
    }

    public List<Integer> count(String s){
        if(s.length() == 1){
            return Collections.singletonList(1);
        }
        List<Integer> countSize = new ArrayList<>();
        char last = s.charAt(0);
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != last){
                int diff = i - start;
                countSize.add(diff);
                last = c;
                start = i;
            }
            if(i == s.length() -1 && last == c){
                int diff = i - start + 1;
                countSize.add(diff);
            }
        }
        return countSize;
    }



    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        List<Integer> counts = count(s);
        Long ans = 0L;
        for (Integer count : counts) {
            ans += getSum(count);
        }
        return (int) (ans % MOD);
    }

    public int countHomogenous1(String s) {
        final int MOD = 1000000007;
        long res = 0;
        char prev = s.charAt(0);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                cnt++;
            } else {
                res += (long) (cnt + 1) * cnt / 2;
                cnt = 1;
                prev = c;
            }
        }
        res += (long) (cnt + 1) * cnt / 2;
        return (int) (res % MOD);
    }


    private int getSum(Integer count) {
        Integer sum = 0;
        while (count > 0){
            sum+= count--;
        }
        return sum;
    }
}
