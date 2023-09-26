package com.zp.leetcode.package2023.september.september26;

public class PassThePillow {


    public static void main(String[] args) {
        //int n = 4,time = 5;
        //int n = 3,time = 2;
        int n = 18,time = 38;
        PassThePillow passThePillow = new PassThePillow();
        System.out.println(passThePillow.passThePillow(n,time));

    }

    public int passThePillow1(int n, int time) {
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }

    public int passThePillow(int n, int time) {
        int pointer = 1;
        for (int i = 0; i < time; i++) {
            System.out.println(pointer);
            pointer = doChangePointer(pointer,i / n);
        }
        return pointer;
    }



    private int doChangePointer(int pointer, int flag) {
        //双数加
        if(flag % 2 == 0){
            return ++pointer;
        //单数减
        }else {
            return --pointer;
        }
    }

}
