package com.zp.leetcode.package_2022.july;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/7/1 2:32 下午
 * 为运算表达式设置优先级
 **/
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String input) {
        if(input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        //考虑全是数字的情况
        int index = 0;
        int length = input.length();
        while(index < length && !isOperation(input.charAt(index))){
            num = num * 10+ input.charAt(index) - '0';
            index++;
        }
        if(index == length){
            result.add(num);
            return result;
        }
        //递归
        for (int i = 0; i < length; i++) {
            final char charAt = input.charAt(i);
            if(isOperation(charAt)){
                String input1 = input.substring(0 , i);
                String input2 = input.substring(i + 1);
                List<Integer> result1 = diffWaysToCompute(input1);
                List<Integer> result2 = diffWaysToCompute(input2);
                //结果运算
                for (Integer integer : result1) {
                    for (Integer integer1 : result2) {
                        final char charAt1 = input.charAt(i);
                        result.add(caculate(integer,charAt1,integer1));
                    }
                }
            }
        }

        return result;
    }

    /**
     * 计算结果
     * @param integer
     * @param charAt1
     * @param integer1
     * @return
     */
    private Integer caculate(Integer integer, char charAt1, Integer integer1) {

        switch(charAt1){
            case '+':
                return integer + integer1;
            case '-':
                return  integer - integer1;
            case '*':
                return integer * integer1;
        }
        return -1;
    }

    /**
     * 是否是操作符号
     * @param charAt
     * @return
     */
    private boolean isOperation(char charAt) {
        return charAt == '+' || charAt == '-' || charAt == '*';
    }

    public static void main(String[] args) {
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        //String input = "2*3-4*5";
        String input = "1+2+3";
        System.out.println(diffWaysToCompute.diffWaysToCompute(input));


    }

}
