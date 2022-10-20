package com.zp.leetcode.package2022.october.october20;

/**
 * @author zhengpeng
 * @date 2022/10/20 8:59 上午
 * 第k个语法符号
 **/
public class KthGrammar {

    public static void main(String[] args) {



    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }


}
