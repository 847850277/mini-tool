package com.zp.leetcode.package2022.september.september26;

/**
 * @author zhengpeng
 * @date 2022/9/26 3:04 下午
 * 反转字符串II
 **/
public class ReverseStr {


    public static void main(String[] args) {

        ReverseStr reverse = new ReverseStr();
        String s = "abcdefg";
        int k = 2;
        final String s1 = reverse.reverseStr(s, k);
        System.out.println(s1);

    }


    /**
     * 反转字符串
     * 给定一个字符串S和整数K，从头开始，每计数至2K个字符串，就反转这2K个字符串的前K个字符串
     * 1、如果剩余字符串少于K个，将剩余的全部反转
     * 2、如果剩余的字符串介于K-2K之前，将前K个反转，剩余的保持原样
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i = i + 2 * k) {
            if (len - i < k) {
                reverse(i, len - 1, chars);
                break;
            } else {
                reverse(i, i + k - 1, chars);
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(int left, int right, char[] chars) {
        char temp;
        while (left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

    }
}
