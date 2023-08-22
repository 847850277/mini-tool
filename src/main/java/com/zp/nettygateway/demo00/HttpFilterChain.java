package com.zp.nettygateway.demo00;

import java.util.ArrayList;
import java.util.List;

public class HttpFilterChain {

    private final List<HttpRequestFilter> filters;

    private HttpFilterChain() {
        this.filters = new ArrayList<>();
    }

    public static HttpFilterChain createDefault() {
        return new HttpFilterChain();
    }

    public HttpFilterChain addFilter(HttpRequestFilter filter) {
        this.filters.add(filter);
        return this;
    }

    public List<HttpRequestFilter> getFilters() {
        return this.filters;
    }

}
