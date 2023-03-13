package com.zp.leetcode.package2023.march.march13;

/**
 * @author zhengpeng
 * @date 2023/3/13 9:18 上午
 **/
public class MinNumberOfHours {

    public static void main(String[] args) {

    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        for (int i : energy) {
            sum += i;
        }
        //精力需要训练的小时数量
        int trainHours = initialEnergy > sum ? 0 : sum + 1 - initialEnergy;
        //增加经验，经验超过对方的值才会打过对方
        for (int i : experience) {
            if(initialExperience <= i){
                trainHours += 1 + (i - initialExperience);
                initialExperience = 2 * i + 1;
            }else {
                initialExperience += i;
            }
        }
        return trainHours;
    }
}
