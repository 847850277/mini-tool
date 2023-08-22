package com.zp.nettygateway.demo03.route;

import java.util.Map;
import java.util.Properties;

public class RouteTable {

    static final private RouteTableSingleton route = RouteTableSingleton.getInstance();

    static public void initTable(Properties properties) {
        route.initTable(properties);
    }

    static public Map<String, String> getTarget(String url) {
        return route.getTarget(url);
    }

}
