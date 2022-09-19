package com.zp.leetcode.package2022.september.september15;

/**
 * @author zhengpeng
 * @date 2022/9/15 10:16 上午
 * 灯泡开关
 **/
public class BulbSwitch {

    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        //System.out.println(bulbSwitch.bulbSwitch(3));
        System.out.println(bulbSwitch.bulbSwitch(4));

    }

    public int bulbSwitch(int n) {
        int[] array = new int[n];

        //step1 全部开启
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }

        //step2 关闭偶数个
        for (int i = 0; i < n; i++) {
            if((i+1) % 2 == 0) {
                array[i] = 0;
            }
        }

        //step3
        for (int i = 0; i < n; i++) {
            if((i+1) % 3 == 0) {
                if(array[i] == 0) {
                    array[i] = 1;
                }else {
                    array[i] = 0;
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if(array[i] == 1) {
                sum ++;
            }
        }

        return sum;
    }


}
