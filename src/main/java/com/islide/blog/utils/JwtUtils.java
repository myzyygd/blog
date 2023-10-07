package com.islide.blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String secret = "123456klllwereee";
    private static final Long TTL = 7200000L;

    public static String createToken(Map<String, Object> claim) {

        return JWT.create()
                .withIssuer("islide")
                .withIssuedAt(new Date())
                .withClaim("userInfo", claim)
                .withExpiresAt(new Date(System.currentTimeMillis() + TTL))
                .sign(Algorithm.HMAC256(secret));
    }

    public static Map<String, Object> verifyJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("islide")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("userInfo").asMap();
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
        }
        return null;
    }
}
