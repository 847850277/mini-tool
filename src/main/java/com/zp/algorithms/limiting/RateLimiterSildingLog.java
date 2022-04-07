package com.zp.algorithms.limiting;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author zhengpeng
 * @date 2022-03-25 17:28
 **/
public class RateLimiterSildingLog {

    /**
     * 阈值
     */
    private Integer qps = 2;

    /**
     * 请求记录的时间戳和数量
     */
    private TreeMap<Long,Long> treeMap = new TreeMap<>();

    /**
     * 清理请求记录间隔，60s
     */
    private long clearTime = 60 * 1000;

    /**
     * 构造方法
     * @param qps
     */
    public RateLimiterSildingLog(Integer qps) {
        this.qps = qps;
    }

    public synchronized boolean tryAcquire(){
        long now = System.currentTimeMillis();
        // 清理过期的老数据，最长60s清理一次
        if (!treeMap.isEmpty() && (treeMap.firstKey() - now) > clearTime) {
            Set<Long> keySet = new HashSet<>(treeMap.subMap(0L, now - 1000).keySet());
            for (Long key : keySet) {
                treeMap.remove(key);
            }
        }
        // 计算当前请求次数
        int sum = 0;
        for (Long value : treeMap.subMap(now - 1000, now).values()) {
            sum += value;
        }
        // 超过QPS限制，直接返回 false
        if (sum + 1 > qps) {
            return false;
        }
        // 记录本次请求
        if (treeMap.containsKey(now)) {
            treeMap.compute(now, (k, v) -> v + 1);
        } else {
            treeMap.put(now, 1L);
        }
        return sum <= qps;

    }

    public static void main(String[] args) throws Exception{
        RateLimiterSildingLog rateLimiterSildingLog = new RateLimiterSildingLog(3);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (rateLimiterSildingLog.tryAcquire()){
                System.out.println(now + "正常通过");
            }else {
                System.out.println(now + "被限流了");
            }
        }

    }

}
