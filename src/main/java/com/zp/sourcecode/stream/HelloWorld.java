package com.zp.sourcecode.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengpeng
 * @date 2022/11/15 1:57 下午
 **/
public class HelloWorld {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //final List<String> collect = list.stream().map(item -> item.toString()).collect(Collectors.toList());

        System.out.println(list.stream());

    }
}
