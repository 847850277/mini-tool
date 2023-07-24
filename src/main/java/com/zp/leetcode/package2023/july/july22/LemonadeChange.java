package com.zp.leetcode.package2023.july.july22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/7/22 09:09
 * 柠檬水找零
 **/
public class LemonadeChange {


    public static void main(String[] args) {
        //int[] array = new int[]{5,5,5,10,20};
        //int[] array = new int[]{5,5,10,10,20};
        int[] array = new int[]{5,5,5,10,5,5,10,20,20,20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(array));
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0,ten = 0;
        for (int bill : bills) {
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five == 0){
                    return false;
                }
                five --;
                ten++;
            }else {
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange(int[] bills) {
        int sum = 0;
        Map<Integer,Integer> keyCountMap = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            int neeReCharge = bill - 5;
            if(neeReCharge > sum){
                return false;
            }
            keyCountMap.put(bill,keyCountMap.getOrDefault(bill,0) + 1);
            //找零
            if(neeReCharge == 5){
                Integer count5 = keyCountMap.getOrDefault(5,0);
                if(count5 == 0){
                    return false;
                }
                count5 = count5 - 1;
                keyCountMap.put(5,count5);
                continue;
            }
            if(neeReCharge == 15){
                Integer count10 = keyCountMap.getOrDefault(10,0);
                Integer count5 = keyCountMap.getOrDefault(5,0);
                if(count5 == 0){
                    return false;
                }
                if(count10 == 0){
                    if(count5 < 3){
                        return false;
                    }
                    count5 = count5 - 3;
                    keyCountMap.put(5,count5);
                }
                if(count10 >= 1){
                    if(count5 < 1){
                        return false;
                    }
                    count5 = count5 - 1;
                    count10 = count10 - 1;
                    keyCountMap.put(5,count5);
                    keyCountMap.put(10,count10);
                }
            }
            sum += 5;
        }
        return true;
    }

}
