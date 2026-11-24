package com.gtech.securitydemo.Filter;

import com.gtech.securitydemo.Util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final  JwtUtil jwtUtil;
    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=null;
        String username=null;

        token=request.getHeader("Authorization"); // Bearer jwt-token
        if(token!=null && token.startsWith("Bearer ")){
             String access_token=token.substring(7);
             username=jwtUtil.getUsername(access_token);


             jwtUtil.validateToken(access_token,)
        }
        filterChain.doFilter(request,response);

    }
}
