package com.gtech.securitydemo.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {
    private String jwt_key="5367566859703373367639792F423F452848284D6251655468576D5A71347437";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of("ROLE","USER"))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(getKeyImpl())
                .compact();
    }
    public Claims parseToken(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(getKeyImpl())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch(Exception e){
            log.info("Something went wrong when parsing the token");
            throw e;
        }
    }
    public boolean validateToken(String token, UserDetails userDetails){
        try {
            Claims claims = parseToken(token);
            String username = claims.getSubject();
            return username.equals(userDetails.getUsername()) && !isExpired(token);
        }catch (Exception e){
            log.info("Something went wrong when validating the token");
            throw e;
        }
    }
    public boolean isExpired(String token){
        Claims claims=parseToken(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }
    public String getUsername(String token){
        Claims claims=parseToken(token);
        return claims.getSubject();
    }
    public Key getKeyImpl(){
        byte[] keyBytes=jwt_key.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
