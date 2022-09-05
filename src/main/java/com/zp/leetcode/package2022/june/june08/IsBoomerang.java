package com.zp.leetcode.package2022.june.june08;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author zhengpeng
 * @date 2022/6/8 3:29 下午
 **/
public class IsBoomerang {


    public boolean isBoomerang(int[][] points) {
        String[] array = new String[points.length - 1];
        int left = 0;
        int temp = points.length - 1;
        for (int right = 1;right < points.length; right++){
            int[] r = points[right];
            int[] l = points[left];
            //遍历，判断是否相同
            while(temp > left){
                int[] t = points[temp];
                if(t[0] == l[0] && t[1] == l[1]){
                    return false;
                }
                temp--;
            }

            //String diff = (r[0] - l[0]) + "," + (r[1] - l[1]);
            String diff = "";
            if(r[0] > l[0]){
                diff = (r[0] - l[0]) + "," + (r[1] - l[1]);
            }else{
                diff = (l[0] - r[0]) + "," + (l[1] - r[1] );
            }
            array[left] = diff;
            left++;
            temp = points.length - 1;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        //斜率
        Set<String> set = new HashSet<String>();
        int count = 0;
        for (String s : array) {
            Integer keyCount = map.getOrDefault(s, 0);
            if(keyCount > 0){
                return false;
            }
            keyCount = keyCount + 1;
            map.put(s,keyCount);
            String[] split = s.split(",");
            Integer x = Integer.valueOf(split[0]);
            Integer y = Integer.valueOf(split[1]);
            if(x != 0){
                count++;
                String rate = new BigDecimal(y).divide(new BigDecimal(x),1000,BigDecimal.ROUND_HALF_UP).toString();
                set.add(rate);
            }
        }
        if(set.size() == 1 && count != 1){
            return  false;
        }
        if(set.size() == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //int[][] array = new int[][]{{1,1},{2,2},{3,3}};
        //int[][] array = new int[][]{{0,0},{1,1},{1,1}};
        //int[][] array = new int[][]{{0,1},{1,0},{0,1}};
        //int[][] array = new int[][]{{1,1},{2,2},{7,7}};
        //int[][] array = new int[][]{{0,0},{0,2},{2,1}};
        //int[][] array = new int[][]{{0,2},{2,1},{0,0}};
        //int[][] array = new int[][]{{0,0},{0,2},{2,1}};
        //int[][] array = new int[][]{{1,0},{0,0},{2,0}};
        //int[][] array = new int[][]{{1,0},{1,1},{1,0}};
        //int[][] array = new int[][]{{73,31},{73,19},{73,45}};
        //int[][] array = new int[][]{{40,93},{45,34},{10,89}};
        int[][] array = new int[][]{{52,68},{23,63},{46,67}};
        IsBoomerang isBoomerang = new IsBoomerang();
        System.out.println(isBoomerang.isBoomerang(array));
        //System.out.println(2/3);
        //System.out.println(4/6);


    }

}
