package com.zp.leetcode.package2023.august.august15;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 字符串查找与替换
 */
public class FindReplaceString {

    public static void main(String[] args) {
        FindReplaceString findReplaceString = new FindReplaceString();
        //String s = "abcd";
        String s = "wreorttvosuidhrxvmvo";
        //int[] indices = new int[]{0,2};
        int[] indices = new int[]{14,12,10,5,0,18};
        //String[] sources = new String[]{"a","cd"};
        String[] sources = new String[]{"rxv","dh","ui","ttv","wreor","vo"};
        //String[] sources = new String[]{"ab","ec"};
        //String[] targets = new String[]{"eee","ffff"};
        String[] targets = new String[]{"frs","c","ql","qpir","gwbeve","n"};
        System.out.println(findReplaceString.findReplaceString(s,indices,sources,targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String ss = new String(s);
        for (int i = 0; i < indices.length; i++) {
            int index1 = indices[i];
            String source = sources[i];
            String target = targets[i];
            int index = ss.indexOf(source);
            while (index != index1 && index != -1){
                index = ss.indexOf(source,index + 1);
            }
            if(index == index1){
                s = s.replace(source,target);
            }
        }
        return s;
    }


    public String findReplaceString1(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), m = indices.length;

        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ops.add(i);
        }
        ops.sort(Comparator.comparingInt(i -> indices[i]));

        StringBuilder ans = new StringBuilder();
        int pt = 0;
        for (int i = 0; i < n;) {
            while (pt < m && indices[ops.get(pt)] < i) {
                pt++;
            }
            boolean succeed = false;
            while (pt < m && indices[ops.get(pt)] == i) {
                if (s.substring(i, Math.min(i + sources[ops.get(pt)].length(), n)).equals(sources[ops.get(pt)])) {
                    succeed = true;
                    break;
                }
                pt++;
            }
            if (succeed) {
                ans.append(targets[ops.get(pt)]);
                i += sources[ops.get(pt)].length();
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }

}
