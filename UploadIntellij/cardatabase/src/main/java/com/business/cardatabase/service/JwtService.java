package com.business.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    static final long expirationTime = 86400000;
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String getToken(String username){

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .signWith(key)
                .compact();

        return token;
    }


    public String getAuthUser(HttpServletRequest request) {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        System.out.println(token);

        if (token!=null){

            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            if (user!=null)
                return user;
        }
        return null;
    }





}
