package com.zp.nettygateway.demo04.route;

import java.util.Map;

/**
 */
public class RouteTable {
    static final private RouteTableSingleton ROUTE = RouteTableSingleton.getInstance();

    static public void initTable() {
        ROUTE.readJsonConfig();
    }

    @Deprecated
    static public Map<String, String> getTarget(String url) {
        return ROUTE.getTarget(url);
    }

    static public String getTargetUrl(String url) {
        return ROUTE.getTargetUrl(url);
    }
}
