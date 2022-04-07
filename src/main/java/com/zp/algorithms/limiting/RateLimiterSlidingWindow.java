package com.zp.algorithms.limiting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengpeng
 * @date 2022-03-24 10:22
 **/
public class RateLimiterSlidingWindow {

    /**
     * 阈值
     */
    private int qps = 2 ;

    /**
     * 时间窗口
     */
    private long windowSize = 1000;

    /**
     * 窗口格子数
     */
    private Integer windowCount = 10;


    private WindowInfo[] windowArrays = new WindowInfo[windowCount];

    /**
     * 构造函数
     * @param qps
     */
    public RateLimiterSlidingWindow(int qps) {
        this.qps = qps;
        long currentTimeMills = System.currentTimeMillis();
        for (int i = 0; i < windowArrays.length; i++) {
            //初始化对应窗口的时间
            windowArrays[i] = new WindowInfo(currentTimeMills,new AtomicInteger(0));
        }

    }





    /**
     * 算法
     * @return
     */
    public synchronized boolean tryAcquire(){
        long currentTimeMills = System.currentTimeMillis();
        // 计算当前时间窗口
        int currentIndex = (int) (currentTimeMills % windowSize / (windowSize /  windowCount));
        int sum = 0;
        for (int i = 0; i < windowArrays.length; i++) {
            WindowInfo windowInfo = windowArrays[i];
            long spendTimeRange = currentTimeMills - windowInfo.getTime();
            if(spendTimeRange > windowSize){
                //重置窗口
                windowInfo.getNumber().set(0);
                windowInfo.setTime(currentTimeMills);
            }
            if(currentIndex == i && windowInfo.getNumber().get() < qps){
                windowInfo.getNumber().incrementAndGet();
            }
            sum = sum + windowInfo.getNumber().get();
        }

        return sum <= qps;

    }


    public static void main(String[] args) throws Exception{
        int qps = 2;
        int count = 100;
        int sleep = 300;
        int success = count * sleep / 1000 * qps;
        System.out.println(String.format("当前QPS限制为:%d,当前测试次数:%d,间隔:%dms,预计成功次数:%d", qps, count, sleep, success));
        success = 0;
        RateLimiterSlidingWindow myRateLimiter = new RateLimiterSlidingWindow(qps);
        for (int i = 0; i < count; i++) {
            Thread.sleep(sleep);
            if (myRateLimiter.tryAcquire()) {
                success++;
                if (success % qps == 0) {
                    System.out.println(LocalTime.now() + ": success, ");
                } else {
                    System.out.print(LocalTime.now() + ": success, ");
                }
            } else {
                System.out.println(LocalTime.now() + ": fail");
            }
        }
        System.out.println();
        System.out.println("实际测试成功次数:" + success);
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class WindowInfo{
        //窗口开始时间
        private  long time;
        //计数器
        private AtomicInteger number;
    }
}
