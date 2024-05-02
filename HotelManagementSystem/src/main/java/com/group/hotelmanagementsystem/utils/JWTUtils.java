package com.group.hotelmanagementsystem.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String SING = "adminLogin";

    public static String getToken(Map<String,String> map){
        try {
            Calendar instance = Calendar.getInstance();

            instance.add(Calendar.DATE,10000);

            JWTCreator.Builder builder = JWT.create();
            map.forEach(builder::withClaim);
            return builder.withExpiresAt(instance.getTime())
                    .sign(Algorithm.HMAC256(SING));
        } catch (IllegalArgumentException | JWTCreationException e) {
            return e.getMessage();
        }
    }

    public static DecodedJWT verify(String token){
        try {
            return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        } catch (JWTVerificationException | IllegalArgumentException e) {
            return null;
        }
    }
}
