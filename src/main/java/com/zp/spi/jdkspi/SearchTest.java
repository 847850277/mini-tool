package com.zp.spi.jdkspi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhengpeng
 * @date 2023/7/31 11:09
 **/
public class SearchTest {

    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchDoc("hello world");
        }
    }
}
