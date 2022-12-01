package com.zp.leetcode.package2022.december.december01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhengpeng
 * @date 2022/12/1 9:34 上午
 * 找到最近的有相同X或Y坐标的点
 **/
public class NearestValidPoint {

    public static void main(String[] args) {
        NearestValidPoint n = new NearestValidPoint();
        //int array[][] = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        //int array[][] = {{3, 4}};
        int array[][] = {{1,2},{3,3},{3,3}};
        //int x = 3, y = 4;
        int x = 1, y = 1;
        //System.out.println(n.nearestValidPoint(x, y, array));
        System.out.println(n.nearestValidPoint1(x, y, array));


    }

    public int nearestValidPoint1(int x, int y, int[][] points) {
        int n = points.length;
        int best = Integer.MAX_VALUE, bestid = -1;
        for (int i = 0; i < n; ++i) {
            int px = points[i][0], py = points[i][1];
            if (x == px) {
                int dist = Math.abs(y - py);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            } else if (y == py) {
                int dist = Math.abs(x - px);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            }
        }
        return bestid;
    }


    public int nearestValidPoint(int x, int y, int[][] points) {
        List<Point> pointsList = new ArrayList<Point>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            //有效的点
            if (point[0] == x) {
                Point point1 = new Point(point[0], point[1]);
                pointsList.add(point1);
                continue;
            }
            //有效的点
            if (point[1] == y) {
                Point point1 = new Point(point[0], point[1]);
                pointsList.add(point1);
                continue;
            }
        }
        //曼哈顿距离
        Integer minDistance = Integer.MAX_VALUE;
        Map<Point, Integer> map = new HashMap<>();
        for (Point point : pointsList) {
            Integer distance = Math.abs(x - point.getX()) + Math.abs(y - point.getY());
            map.put(point, distance);
            minDistance = Math.min(minDistance, distance);
        }
        //下标最小的点
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Point, Integer> pointIntegerEntry : map.entrySet()) {
            if (pointIntegerEntry.getValue().compareTo(minDistance) == 0) {
                Integer index = pointIntegerEntry.getKey().getX();
                if(index == x && pointIntegerEntry.getKey().getY() == y){
                    index = 0;
                }
                res = Math.min(index, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static class Point{

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Objects.equals(x, point.x) && Objects.equals(y, point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        private Integer x;

        private Integer y;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }

}
