package com.zp.leetcode.package2023.march.march21;

/**
 * @author zhengpeng
 * @date 2023/3/21 9:00 上午
 * 温度转换
 **/
public class ConvertTemperature {

    public static void main(String[] args) {

        ConvertTemperature convertTemperature = new ConvertTemperature();
        //double[] doubles = convertTemperature.convertTemperature(36.50);
        double[] doubles = convertTemperature.convertTemperature(122.11);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public double[] convertTemperature(double celsius) {
//        double left = celsius + 275.15d;
//        double right = celsius * 1.8d + 32.00d;
//        return new double[]{left,right};
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }

}
