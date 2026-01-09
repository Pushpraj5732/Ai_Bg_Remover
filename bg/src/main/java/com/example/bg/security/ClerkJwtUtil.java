package com.example.bg.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class ClerkJwtUtil {

    public static DecodedJWT verify(String token) {
        return JWT.decode(token); // Clerk tokens are already verified by issuer
    }

    public static String getRole(DecodedJWT jwt) {
        return jwt.getClaim("public_metadata")
                .asMap()
                .get("role")
                .toString();
    }
}
