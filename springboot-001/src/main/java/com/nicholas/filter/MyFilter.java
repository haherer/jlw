package com.nicholas.filter;


import javax.servlet.*;
import java.io.IOException;

//过滤器
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
