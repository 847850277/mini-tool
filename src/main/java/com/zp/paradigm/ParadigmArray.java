package com.zp.paradigm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022-03-24 14:45
 * 范型数组
 **/
public class ParadigmArray {




    public static void main(String[] args) {
        //declarationMethod();

        // 返回泛型数组
//        Integer array[] = fun1(1,2,3,4,5,6) ;
//        fun2(array) ;

        //oracleDemo();

    }

    /*
    private static void oracleDemo() {
        List<String>[] lsa = new List<String>[10];// Not really allowed
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;//Unsound,but passes run time store check
        String s = lsa[1].get(0);// Run-time error ClassCastException
    }
     */


    // 接收可变参数
    public static <T> T[] fun1(T...arg){
        // 返回泛型数组
        return arg ;
    }
    // 输出
    public static <T> void fun2(T param[]){
        System.out.print("接收泛型数组：") ;
        for(T t:param){
            System.out.print(t + "、") ;
        }
    }

//    public ArrayWithTypeToken(Class<T> type, int size) {
//        array = (T[]) Array.newInstance(type, size);
//    }




    /**
     * 声明方法
     */
    private static void declarationMethod() {
        //List<String>[] list11 = new ArrayList<String>[10]; //编译错误，非法创建
        //List<String>[] list12 = new ArrayList<?>[10]; //编译错误，需要强转类型
        List<String>[] list13 = (List<String>[]) new ArrayList<?>[10]; //OK，但是会有警告
        //List<?>[] list14 = new ArrayList<String>[10]; //编译错误，非法创建
        List<?>[] list15 = new ArrayList<?>[10]; //OK
        List<String>[] list6 = new ArrayList[10]; //OK，但是会有警告
    }


}
