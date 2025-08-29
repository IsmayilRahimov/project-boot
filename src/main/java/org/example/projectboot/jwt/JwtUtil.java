package org.example.projectboot.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final Long EXPIRATION_TIME = 864000000L;


                 // Token yaratmaq
    public  String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // token kime aiddir
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
              // Tokeni acib yoxlamaq
    public  String validateTokenUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key) // hansi acarla imzalanib
                .build()
                .parseClaimsJws(token) // tokeni acir ve yoxlayir
                .getBody()
                .getSubject();   // icindeki username - i qaytarir
    }
}
