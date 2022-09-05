package com.zp.leetcode.package2022.july.july24;

/**
 * @author zhengpeng
 * @date 2022/7/24 9:13 下午
 * 公交站间的距离
 **/
public class DistanceBetweenBusStops {

    public static void main(String[] args) {
        DistanceBetweenBusStops distance = new DistanceBetweenBusStops();
        int[] array = new int[]{1,2,3,4};
        //int start = 0;
        int start = 2;
        //int destination = 1;
        //int destination = 2;
        int destination = 3;
        System.out.println(distance.distanceBetweenBusStops(array,start,destination));


    }


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length = distance.length;
        int i = start;
        int j = start;
        int distanceRight = 0;
        int distanceLeft = 0;
        while (i != destination) {
            distanceRight += distance[i];
            i++;
            if(i == length){
                i = 0;
            }
        }
        while (j != destination){
            j--;
            if(j < 0){
                j = length - 1;
            }
            distanceLeft += distance[j];
        }

        return Math.min(distanceLeft,distanceRight);
    }

}
