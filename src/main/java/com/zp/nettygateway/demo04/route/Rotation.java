package com.zp.nettygateway.demo04.route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 负载均衡：轮询算法
 */
public class Rotation implements LoadBalance {

    private Map<String, Integer> serverFlag;
    private Map<String, Integer> serverAmount;

    /**
     * 得到相关服务器集群的数量并初始化起始标记位置
     * @param server 服务器
     */
    Rotation(Map<String, List<String>> server) {
        serverFlag = new HashMap<>(server.size());
        serverAmount = new HashMap<>(server.size());
        for (String serverGroup: server.keySet()) {
            serverFlag.put(serverGroup, 0);
            serverAmount.put(serverGroup, server.get(serverGroup).size());
        }
    }

    /**
     * 返回当前标记位的服务器地址，标记位向后移动一位
     * @param server 所有服务器列表
     * @param serverGroup 服务器组名称
     * @return 转换后的后台服务器请求地址
     */
    @Override
    public String get(Map<String, List<String>> server, String serverGroup) {
        int index = serverFlag.get(serverGroup);
        String target;
        synchronized (serverFlag.get(serverGroup)) {
            target = server.get(serverGroup).get(index);
            int nextIndex = serverFlag.get(serverGroup) + 1;
            if (nextIndex >= serverAmount.get(serverGroup)) {
                nextIndex = 0;
            }
            serverFlag.put(serverGroup, nextIndex);
        }
        return target;
    }
}
