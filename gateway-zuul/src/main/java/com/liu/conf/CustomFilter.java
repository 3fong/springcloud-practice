package com.liu.conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liulei
 * @Description 自定义过滤器
 * @create 2017/10/26 20:33
 */
public class CustomFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    /**
     * @Title: filterType
     * @Description: 过滤器类型
     * @param: null
     */
    public String filterType() {
        return "pre";
    }

    /**
     * @Title: filterOrder
     * @Description: 过滤器顺序
     * @param: null
     */
    public int filterOrder() {
        return 1;
    }

    /**
     * @Title: shouldFilter
     * @Description: 是否开启过滤
     * @param: null
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @Title: run
     * @Description: 过滤逻辑
     * @param: null
     */
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("发送 %s 请求到 %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
