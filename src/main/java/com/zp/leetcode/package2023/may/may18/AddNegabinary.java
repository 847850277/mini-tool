package com.zp.leetcode.package2023.may.may18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/5/18 9:01 上午
 * 负二进制相加
 **/
public class AddNegabinary {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,1,1,1,1};
        int[] array2 = new int[]{1,0,1};
        AddNegabinary addNegabinary = new AddNegabinary();
        System.out.println(addNegabinary.addNegabinary(array1,array2));

    }


    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0){
            int x = carry;
            if (i >= 0){
                x += arr1[i];
            }
            if(j >= 0){
                x += arr2[j];
            }
            if(x >= 2){
                ans.add(x - 2);
                carry = -1;
            }else if(x >= 0){
                ans.add(x);
                carry = 0;
            }else {
                ans.add(1);
                carry = 1;
            }
            --i;
            --j;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0){
            ans.remove(ans.size() - 1);
        }
        int[] arr = new int[ans.size()];
        for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
            arr[i] = ans.get(j);
        }
        return arr;
    }
}
