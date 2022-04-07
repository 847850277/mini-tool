package com.zp.algorithms.limiting;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhengpeng
 * @date 2022-03-31 16:44
 **/
public class RateLimiterGuava {

    public static void main(String[] args) throws Exception{
        // qps 2
        RateLimiter rateLimiter = RateLimiter.create(2);
        for (int i = 0; i < 10; i++) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
            System.out.println(time + ":" + rateLimiter.tryAcquire());
            Thread.sleep(250);
        }

    }
}
