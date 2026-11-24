package com.gtech.securitydemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String authorization=httpServletRequest.getHeader("Authorization");

        log.info("Request passess through your logging filter with authorization value:"+authorization);
        chain.doFilter(request, response);
    }
}
