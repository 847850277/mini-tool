package com.zp.leetcode.package2023.march.march02;

/**
 * @author zhengpeng
 * @date 2023/3/2 9:02 上午
 * 二进制转字符串
 **/
public class PrintBin {

    public static void main(String[] args) {
        PrintBin bin = new PrintBin();
        System.out.println(bin.printBin(0.625d));
    }


    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0){
            num = num * 2;
            int digit = (int) num;
            sb.append(digit);
            num = num - digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
