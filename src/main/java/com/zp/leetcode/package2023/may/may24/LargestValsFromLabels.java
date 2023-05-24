package com.zp.leetcode.package2023.may.may24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/5/23 2:43 下午
 * 受标签影响的最大值
 **/
public class LargestValsFromLabels {


    public static void main(String[] args) {
        LargestValsFromLabels largestValsFromLabels = new LargestValsFromLabels();
        int[] values = new int[]{5,4,3,2,1};
        //int[] values = new int[]{99,2,133,23,1};
        int[] labels = new int[]{1,1,2,2,3};
        int numWanted = 3;
        int useLimit = 1;
        largestValsFromLabels.largestValsFromLabels(values,labels,numWanted,useLimit);


    }


    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
       int n = values.length;
       Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id,(a,b) -> values[b] - values[a]);
        int ans = 0;
        int num = 0;
        Map<Integer,Integer> labelMap = new HashMap<Integer,Integer>(values.length);
        for (Integer integer : id) {
            Integer labelNum = labelMap.getOrDefault(labels[integer], 0);
            if (labelNum < useLimit && num < numWanted) {
                ans += values[integer];
                labelMap.put(labels[integer], labelNum + 1);
                num++;
            }
        }
        return ans;
    }

}
