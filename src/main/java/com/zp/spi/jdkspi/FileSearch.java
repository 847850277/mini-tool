package com.zp.spi.jdkspi;

import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/7/31 11:08
 **/
public class FileSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.printf("文件搜索" + keyword);
        return null;
    }
}
