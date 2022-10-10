package com.zp.leetcode.package2022.october.october03;


/**
 * @author zhengpeng
 * @date 2022/10/10 11:03 上午
 * 括号的分数
 * 题目描述
 * - 给定一个平衡括号字符串s，按如下规则计算字符串的分数
 * - （）得一分
 * -  AB得 A + B 分，其中 A 和 B 是平衡括号字符串
 * - （A）得 2 * A 分，其中 A 是平衡括号的字符串
 *
 * - 根据规则一、只有（）会产生得分
 * - 根据规则二、我们将每个（）产生的贡献值相加
 * - 根据规则三、我们计算每个（）的深度，即可以得出当前（）的贡献值，贡献值为2^dep，dep为当前括号的深度，初始深度值为0
 *
 * 例如，字符串 (()(()())) 可以将其视为下面的树：
 *             (10)             0
 *             ／ \
 *           (1)  (4)           1
 *                /  \
 *              (1)  (1)        2
 * 树中有三个叶子节点，第 1 层有 1 个叶子结点，第 2 层有 2 个叶子节点。所以最终答案是：2 * 2 * (2 ^ 0 + 2 ^ 0) + 2 * 1
 *
 *
 **/
public class ScoreOfParentheses {


    public static void main(String[] args) {
        String str = "(()(()()))";
        ScoreOfParentheses s = new ScoreOfParentheses();
        System.out.println(s.scoreOfParentheses(str));
    }

    /**
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {

        int deep = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //计算深度
            deep += c == '(' ? 1 : -1;
            //找到一对 ()
            if (c == ')' && i >= 1 && chars[i - 1] == '(') {
                //计算贡献值
                ans += 1 << deep;
            }
        }
        return ans;
    }

}
