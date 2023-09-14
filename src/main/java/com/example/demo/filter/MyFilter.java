package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("request: {}", servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
//        log.info("resp: {}", servletResponse);
    }
}
