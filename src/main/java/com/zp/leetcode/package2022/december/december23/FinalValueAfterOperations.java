package com.zp.leetcode.package2022.december.december23;

/**
 * @author zhengpeng
 * @date 2022/12/23 9:12 上午
 * 执行操作之后的变量值
 **/
public class FinalValueAfterOperations {

    public static void main(String[] args) {




    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if ("X++".equals(operation) || "++X".equals(operation)) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
