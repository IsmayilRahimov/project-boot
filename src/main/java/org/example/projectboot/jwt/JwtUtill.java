package org.example.projectboot.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtill {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final Long EXPIRATION_TIME = 864000000L;


                 // Token yaratmaq
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // token kime aiddir
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
              // Tokeni acib yoxlamaq
    public static String validateTokenUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key) // hansi acarla imzalanib
                .build()
                .parseClaimsJws(token) // tokeni acir ve yoxlayir
                .getBody()
                .getSubject();   // icindeki username - i qaytarir
    }
}
