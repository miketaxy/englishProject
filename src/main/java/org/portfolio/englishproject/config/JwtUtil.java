package org.portfolio.englishproject.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.NoArgsConstructor;
import org.portfolio.englishproject.model.User;


import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    public static final SecretKey SECRET_KEY = getSigningKey();


    public static String generateToken(User user) {
        return Jwts
                .builder()
                .subject(user.getUsername())
                .signWith(SECRET_KEY)
                .expiration(new Date(System.currentTimeMillis() + 864000000))
                .compact();
    }
    private static SecretKey getSigningKey(){
        return Jwts.SIG.HS256.key().build();
    }


    public static Claims parseToken(String token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static String getUsername(String bearerToken){
        String token = bearerToken.substring(7);
        return parseToken(token).getSubject();
    }
}