package com.zp.leetcode.package2022.july.july13;

import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/7/13 9:09 上午
 * 行星碰撞
 **/
public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        //int[] array = new int[]{1,2,3,4};
        //int[] array = new int[]{5,10,-5};
        //int[] array = new int[]{8,-8};
        //int[] array = new int[]{10,2,-5};
        //int[] array = new int[]{-2,-1,1,2};
        //int[] array = new int[]{-2,-2,-2,1};
        int[] array = new int[]{-2,-2,-1,2};
        final int[] ints = asteroidCollision.asteroidCollision(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }



    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids) {
            pushStack(stack,asteroid);
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (Integer integer : stack) {
            result[index] = integer;
            index++;
        }
        return result;
    }

    /**
     * 根据条件判断出栈还是入栈
     * @param stack
     * @param integer
     */
    private void pushStack(Stack<Integer> stack, Integer integer) {
        if(stack.isEmpty()){
            stack.push(integer);
        }else{
            final Integer peek = stack.peek();
            if (canPop(peek,integer)){
                stack.pop();
                if((peek + integer) != 0){
                    pushStack(stack,integer);
                }
            }else if(canPush(peek,integer)){
                stack.push(integer);
            }
        }
    }

    /**
     * 能够入栈
     * @param peek
     * @param integer
     * @return
     */
    private boolean canPush(Integer peek, Integer integer) {
        if(peek > 0 && integer < 0 && ( (peek + integer) > 0 )){
            return false;
        }
//        if(peek < 0 && integer > 0 && ((peek + integer) < 0)){
//            return false;
//        }

        return true;
    }

    private boolean canPop(Integer peek, Integer integer) {
//        if(integer > 0 && peek < 0 &&( (integer + peek) > 0) ){
//            return true;
//        }else
        if(integer < 0 && peek > 0 && ( (integer + peek) < 0 ) ){
            return true;
        }else if((peek + integer) == 0 && peek > 0){
            return true;
        }
        return false;
    }
}
