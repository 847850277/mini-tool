package com.zp.leetcode.package2022.december.december22;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/12/22 2:03 下午
 * 分发饼干
 **/
public class FindContentChildren {

    public static void main(String[] args) {
        //int[] g = new int[]{1,2,3};
        int[] g = new int[]{1,2};
        //int[] s = new int[]{1,1};
        int[] s = new int[]{1,2,3};
        FindContentChildren f = new FindContentChildren();
        System.out.println(f.findContentChildren(g,s));
    }


    /**
     * 最大的饼干喂给胃口最大的孩子、每一步都是局部最优解法
     * @param g 孩子想吃最大数组
     * @param s 饼干数组
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int start = g.length - 1;
        int sIndex = s.length - 1;
        for (int i = start; i >= 0 ; i--) {
            // 饼干分完终止
            if(sIndex < 0){
                break;
            }
            int maxS = s[sIndex];
            int maxG = g[i];
            //满足可分
            if(maxS >= maxG){
                sIndex--;
                ans++;
            }
            //不满足、这次循环结束，当前饼干分给下一个胃口最大的小孩
        }
       return ans;
    }
}
