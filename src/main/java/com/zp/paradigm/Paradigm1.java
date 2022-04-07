package com.zp.paradigm;

import java.util.List;

/**
 * @author zhengpeng
 * @date 2022-03-24 14:13
 * 范型
 **/
public class Paradigm1 {

    // 如下两个方法不会报错
    public static void funA(A a) {
        // ...
    }
    public static void funB(B b) {
        funA(b);
        // ...
    }

    // 如下funD方法会报错
    public static void funC(List<? extends A> listA) {
        // ...
    }
    public static void funD(List<B> listB) {
        // Unresolved compilation problem: The method doPrint(List<A>) in the type test is not applicable for the arguments (List<B>)
        //此行编译会报错
        funC(listB);
        // ...
    }

}
class A{

}
class B extends A {}



