package com.zp.algorithms.limiting;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengpeng
 * @date 2022-03-24 09:51
 **/
public class RateLimiterSimpleWindow {

    // 阈值
    private static Integer QPS = 2;
    // 时间窗口
    private static long TIME_WINDOWS = 1000;
    // 计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger();

    private static long START_TIME = System.currentTimeMillis();

    public synchronized static boolean tryAcquire(){
        //消耗时间范围
        long spendTimeRange = System.currentTimeMillis() - START_TIME;
        //重置计数器和时间
        if(spendTimeRange > TIME_WINDOWS){
            System.out.println("重置时间窗口，消耗时间返回：" + spendTimeRange);
            REQ_COUNT.set(0);
            START_TIME = System.currentTimeMillis();
        }
        return REQ_COUNT.incrementAndGet() <= QPS;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{

        //Thread.sleep(400);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if(!tryAcquire()){
                System.out.println(now + "被限流了");
            }else {
                System.out.println(now + "正常放行");
            }

        }

    }
}
