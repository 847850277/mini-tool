package com.zp.leetcode.package2023.september.september27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 餐厅过滤器
 */
public class FilterRestaurants {


    public static void main(String[] args) {
        int[][] restaurants = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;
        FilterRestaurants filterRestaurants = new FilterRestaurants();
        List<Integer> integers = filterRestaurants.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        System.out.println(integers);


    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<int[]> filtered = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance && !(veganFriendly == 1 && restaurants[i][2] == 0)) {
                filtered.add(restaurants[i]);
            }
        }
        filtered.sort((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<Integer> res = new ArrayList<Integer>();
        for (int[] v : filtered) {
            res.add(v[0]);
        }
        return res;
    }

}
