package com.zp.leetcode.package2023.september.september01;

public class WaysToBuyPensPencils {

    public static void main(String[] args) {
//        int total = 20;
//        int cost1 = 10;
//        int cost2 = 5;

//        int total = 5;
//        int cost1 = 10;
//        int cost2 = 10;

        int total = 10000;
        int cost1 = 1;
        int cost2 = 1;

        WaysToBuyPensPencils waysToBuyPensPencils = new WaysToBuyPensPencils();
        System.out.println(waysToBuyPensPencils.waysToBuyPensPencils(total,cost1,cost2));
    }


    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        /*
        int divide1 = total / cost1;
        int divide2 = total / cost2;
        Long sum = 0L;
        for (int i = 0; i <= divide1; i++) {
            for (int j = 0; j <= divide2; j++) {
                int sumCost =  i * cost1 + j * cost2;
                if(sumCost <= total){
                    sum++;
                }
            }
        }
        return  sum;
         */
        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }
        long res = 0, cnt = 0;
        while (cnt * cost1 <= total) {
            res += (total - cnt * cost1) / cost2 + 1;
            cnt++;
        }
        return res;

    }

}
