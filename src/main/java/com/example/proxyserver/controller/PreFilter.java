package com.example.proxyserver.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.util.Enumeration;

@Slf4j
public class PreFilter extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        StringBuffer strLog=new StringBuffer();
        strLog.append("\n------ New Request ------\n");
        strLog.append(String.format("Server: %s Method: %s Path: %s \n",ctx.getRequest().getServerName()
                ,ctx.getRequest().getMethod(),
                ctx.getRequest().getRequestURI()));
        Enumeration<String> enume= ctx.getRequest().getHeaderNames();
        String header;
        while (enume.hasMoreElements())
        {
            header=enume.nextElement();
            strLog.append(String.format("Headers: %s = %s \n",header,ctx.getRequest().getHeader(header)));
        };
        log.info(strLog.toString());
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public String filterType() {
        return "pre";
    }

}
