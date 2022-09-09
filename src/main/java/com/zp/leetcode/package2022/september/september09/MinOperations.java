package com.zp.leetcode.package2022.september.september09;

/**
 * @author zhengpeng
 * @date 2022/9/9 6:09 下午
 **/
public class MinOperations {

    /**
     * 文件夹操作日志收集器
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String s : logs) {
            if (s.equals("../")) depth = Math.max(0, depth - 1);
            else if (!s.equals("./")) depth++;
        }
        return depth;
    }



}
