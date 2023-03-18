package com.zp.leetcode.package2023.march.march18;

/**
 * @author zhengpeng
 * @date 2023/3/18 2:54 下午
 **/
public class CheckPalindromeFormation {

    public static void main(String[] args) {

        boolean result = true || false;
        System.out.println(result);
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return checkConcatenation(a,b) || checkConcatenation(b,a);
    }

    private boolean checkConcatenation(String a, String b) {
        int n = a.length();
        int left = 0,right = n -1;
        while(left < right && a.charAt(left) == b.charAt(right)){
            left++;
            right--;
        }
        if(left >= right){
            return true;
        }
        return checkSelfPalindrome(a,left,right) || checkSelfPalindrome(b,left,right);

    }

    private boolean checkSelfPalindrome(String a, int left, int right) {
        while (left < right && a.charAt(left) == a.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }

}
