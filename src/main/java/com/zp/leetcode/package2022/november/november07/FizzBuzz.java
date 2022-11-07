package com.zp.leetcode.package2022.november.november07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/11/7 4:34 下午
 * Fizz Buzz
 **/
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(3));

    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if(i % 3 == 0){
                res.add("Fizz");
            }else if(i % 5 == 0){
                res.add("Buzz");
            }else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
