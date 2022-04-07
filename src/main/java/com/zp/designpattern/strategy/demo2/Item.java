package com.zp.designpattern.strategy.demo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    private String upcCode;
    private int price;

}
