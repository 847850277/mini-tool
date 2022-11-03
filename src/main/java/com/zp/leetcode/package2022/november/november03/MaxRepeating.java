package com.zp.leetcode.package2022.november.november03;

/**
 * @author zhengpeng
 * @date 2022/11/3 9:54 上午
 * 最大重复子字符串
 **/
public class MaxRepeating {

    public static void main(String[] args) {

        MaxRepeating m = new MaxRepeating();
        String sequence = "ababc";
        //String word = "ab";
        String word = "ba";
        System.out.println(m.maxRepeating(sequence,word));
    }


    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String tempWord = word;
        while (sequence.indexOf(tempWord) >= 0){
            tempWord = tempWord + word;
            count++;
        }
        return count;
    }
}
