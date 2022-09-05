package com.zp.leetcode.package2022.june.june01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/5/31 9:29 上午
 * 小行星碰撞
 **/
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids) {
            if(!stack.isEmpty() && asteroid > 0){

                //final Integer peek = stack.peek();
                stack.push(asteroid);
                //调整
                //iterPush(stack,asteroid);
//                if(peek > 0){
//                    stack.push(asteroid);
//                }else if(peek <= 0){
//                    if((asteroid - Math.abs(peek)) > 0){
//                        //负数出栈
//                        stack.pop();
//                        //正数入栈
//                        stack.push(asteroid);
//                    }else if((asteroid - Math.abs(peek)) == 0) {
//                        //负数出栈
//                        stack.pop();
//
//                    }else{
//                        //什么都不用做
//                    }
//                }
            }else if(!stack.isEmpty() && asteroid <= 0){


                //final Integer peek = stack.peek();
                //调整
                iterPush(stack,asteroid);
//                if(peek > 0){
//                    if((peek - Math.abs(asteroid)) > 0){
//                        //什么都不用做
//                    }else if((peek - Math.abs(asteroid)) == 0){
//                        //正数出栈
//                        stack.pop();
//                    } else{
//                        //正数出栈
//                        stack.pop();
//                        //负数入栈
//                        stack.push(asteroid);
//                    }
//                }else{
//                    stack.push(asteroid);
//                }
            } else if(asteroid > 0 && stack.isEmpty()){
                stack.push(asteroid);
            }else if(asteroid <= 0 && stack.isEmpty()){
                list.add(asteroid);
            }
        }
        int size = stack.size() + list.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= list.size() ; i--) {
            final Integer pop = stack.pop();
            result[i] = pop;
        }
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
        }
        return result;
    }

    /**
     * 行星在栈内相撞
     * @param stack
     * @param asteroid
     */
    private void iterPush(Stack<Integer> stack, int asteroid) {

        int peek = stack.peek();
        while (canPopAndPop(peek,asteroid) && !stack.isEmpty()){
            stack.pop();
            if(!stack.isEmpty()){
                peek = stack.peek();
            }
        }
        //等循环处理完,

        // 碰撞后为0
        if(peek + asteroid == 0){
            stack.pop();
        }
        // 不为0
        if(asteroid > 0 && (asteroid + peek) > 0){
            //什么都不做
        }

        if(asteroid < 0 && (asteroid + peek) < 0){
            stack.push(asteroid);
        }







    }


    private boolean canPopAndPop(Integer peek, int asteroid) {

        if(asteroid > 0){

           if(peek >= 0){
               return false;
           }
           if(peek < 0){
               if((peek + asteroid) < 0){
                   return true;
               }else{
                   return false;
               }
           }
        }else{

            if(peek <= 0){
                return false;
            }
            if(peek > 0){
                if((peek + asteroid) < 0){
                    return true;
                }else{
                    return false;
                }

            }
        }

        return  false;
    }

    /**
     * 标准答案
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (s.empty() || s.peek() < 0 || asteroids[p] > 0) {
                s.push(asteroids[p]);
            } else if (s.peek() <= -asteroids[p]) {
                if (s.pop() < -asteroids[p]) {
                    continue;
                }
            }
            p++;
        }
        int[] ret = new int[s.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = s.pop();
        }
        return ret;
    }


    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        //int[] array = new int[]{5,10,-5};
        //int[] array = new int[]{8,-8};
        int[] array = new int[]{10,2,-5,-100};
        //new ArrayList<>(100);
        //ArrayList<Integer> integers = new ArrayList<>(100);
        //integers.add(99,100);
        final int[] ints = asteroidCollision.asteroidCollision(array);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }

    }

}
