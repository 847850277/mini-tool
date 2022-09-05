package com.zp.leetcode.package2022.april.april0420;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022-04-19 10:07
 * 杨辉三角二
 **/
public class YangTriangle2 {

    @SuppressWarnings("Duplicates")
    public List<Integer> getRow(int rowIndex) {

        int numRows = rowIndex + 1;

        if(numRows == 1){
            List<Integer> items = new ArrayList<>();
            items.add(1);
            return items;
        }else {
            List<int[]> list = initList(numRows);
            List<List<Integer>> result = new ArrayList<>(numRows);
            //遍历设置值
            for (int i = 0; i < list.size(); i++) {
                final int[] ints = list.get(i);
                if(i == 0){
                    List<Integer> items = new ArrayList<>();
                    items.add(1);
                    result.add(items);
                }else if(i == 1){
                    List<Integer> items = new ArrayList<>();
                    items.add(1);
                    items.add(1);
                    result.add(items);
                } else {
                    List<Integer> items = buildItems(ints,i,list.get(i - 1));
                    result.add(items);
                }
            }
            return result.get(rowIndex);
        }
    }

    @SuppressWarnings("Duplicates")
    private List<Integer> buildItems(int[] ints, int i, int[] preInts) {
        ArrayList<Integer> items = new ArrayList<>();
        //头
        items.add(1);
        for(i = 1 ; i < ints.length - 1; i++){
            ints[i] = preInts[i - 1] + preInts[i];
            items.add(ints[i]);
        }
        //尾
        items.add(1);
        return items;
    }

    /**
     * 初始化数据,
     * @param numRows
     * @return
     */
    @SuppressWarnings("Duplicates")
    private List<int[]> initList(int numRows) {
        ArrayList<int[]> list = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            int[] array = new int[i];
            array[0] = 1;
            array[i - 1] = 1;
            list.add(array);
        }
        return  list;
    }


    public static void main(String[] args) {

        YangTriangle2 yangTriangle2 = new YangTriangle2();

        System.out.println(yangTriangle2.getRow(0));
        System.out.println(yangTriangle2.getRow(1));
        System.out.println(yangTriangle2.getRow(2));
        System.out.println(yangTriangle2.getRow(3));
        System.out.println(yangTriangle2.getRow(4));
        System.out.println(yangTriangle2.getRow(5));
        System.out.println(yangTriangle2.getRow(6));
    }

}
