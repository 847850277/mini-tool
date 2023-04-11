package com.zp.leetcode.package2023.april.april11;

/**
 * @author zhengpeng
 * @date 2023/4/11 9:27 上午
 * 困于环中的机器人
 **/
public class IsRobotBounded {


    public static void main(String[] args) {
        String str = "GGLLGG";
        IsRobotBounded isRobot = new IsRobotBounded();
        System.out.println(isRobot.isRobotBounded(str));

    }



    public boolean isRobotBounded(String instructions) {
        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};

        int directIndex = 0;
        int x = 0,y = 0;
        int n = instructions.length();
        for (int i = 0; i < n; i++) {
            char c = instructions.charAt(i);
            if(c == 'G'){
                x += direct[directIndex][0];
                y += direct[directIndex][1];
            }else if(c == 'L'){
                directIndex += 3;
                directIndex %= 4;
            }else {
                directIndex++;
                directIndex %= 4;
            }
        }
        return directIndex != 0 || (x == 0 && y == 0);
    }

}
