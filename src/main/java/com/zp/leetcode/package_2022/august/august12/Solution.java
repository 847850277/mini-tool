package com.zp.leetcode.package_2022.august.august12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/8/12 9:22 上午
 * 用户分组
 **/
public class Solution {

    public static void main(String[] args) {

        int[] array = new int[]{3,3,3,3,3,1,3};
        Solution solution = new Solution();
        solution.groupThePeople(array);

    }

    /**
     * 用户分组
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            final int groupSize = groupSizes[i];
            List<Integer> list = map.getOrDefault(groupSize,new ArrayList<Integer>());
            list.add(i);
            map.put(groupSize,list);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            final Integer index = integerListEntry.getKey();
            final List<Integer> values = integerListEntry.getValue();
            List cur = new ArrayList<Integer>();
            for (int i = 0; i < values.size(); i++) {
                cur.add(values.get(i));
                if(cur.size() == index) {
                    result.add(cur);
                    cur = new ArrayList();
                }
            }
        }
        return result;
    }

    /**
     * 用户分组
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople1(int[] groupSizes) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> valueCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < groupSizes.length; i++) {
            final int groupSize = groupSizes[i];
            map.put(i, groupSize);
            valueCount.put(groupSize, valueCount.getOrDefault(groupSize,0) + 1);
        }
        //遍历map，划分集合
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            final Integer index = integerIntegerEntry.getKey();
            final Integer value = integerIntegerEntry.getValue();
            //封装结果集
            buildListAndGet(index,value,valueCount);
        }
        return result;
    }

    private void buildListAndGet(Integer index, Integer value, Map<Integer, Integer> valueCount) {
    }


}
