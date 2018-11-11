package com.vkteam.templates.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JWTService {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(String data) {
        return Jwts.builder().setSubject(data).signWith(key).compact();
    }

    public String[] encrypt(String jwt) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody().getSubject().split("#", 2);
    }
}
