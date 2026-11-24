package com.gtech.securitydemo.Services;

import com.gtech.securitydemo.Util.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * 1000-->1sec
 * 60000->60sec
 * 5*60,000-->30,0,000 mili Sec
 */
@Service
public class AuthServiceImpl implements AuthService {
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private final JwtUtil jwtUtil;

    @Override
    public String userLogin( ) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return jwtUtil.generateToken(username);
    }
}
