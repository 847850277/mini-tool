package com.zp.leetcode.package2023.february.february13;

/**
 * @author zhengpeng
 * @date 2023/2/13 9:09 上午
 * 替换子串得到平衡字符串
 **/
public class BalancedString {

    public static void main(String[] args) {
        BalancedString balancedString = new BalancedString();
        //String str = "QWER";
        String str = "QQWEEWQR";
        System.out.println(balancedString.balancedString(str));
    }

    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[inx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();
        
        if(check(cnt,partial)){
            return 0;
        }
        for (int l = 0,r = 0;l < s.length();l++){
            while (r < s.length() && !check(cnt,partial)){
                cnt[inx(s.charAt(r))]--;
                r++;
            }
            if(!check(cnt,partial)){
                break;
            }
            res = Math.min(res,r - l);
            cnt[inx(s.charAt(l))]++;
        }
        return res;
    }

    private boolean check(int[] cnt, int partial) {
        if(cnt[inx('Q')] > partial){
            return false;
        }
        if(cnt[inx('W')] > partial){
            return false;
        }
        if(cnt[inx('E')] > partial){
            return false;
        }
        if(cnt[inx('R')] > partial){
            return false;
        }
        return true;
    }


    public int inx(char c){
        return c - 'A';
    }
}
