package com.zp.spi.jdkspi;

import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/7/31 11:09
 **/
public class DatabaseSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("数据库搜索" + keyword);
        return null;
    }
}
