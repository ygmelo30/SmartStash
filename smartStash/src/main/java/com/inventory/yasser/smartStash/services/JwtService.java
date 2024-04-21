package com.inventory.yasser.smartStash.services;

import com.inventory.yasser.smartStash.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String secretKey = "52fca9b8517635e4e1ef268e6c6a4afef3d09f6a5f47cc8a6453d67de831b037";

    public String generateToken(User user) {
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(getSignInKey())
                .compact();

        return token;
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaims (String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim (String token, Function<Claims, T> resolver) {
        Claims claims = getAllClaims(token);
        return resolver.apply(claims);
    }

    public String extractUsername (String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isValid (String token, UserDetails user) {
        String username = extractUsername(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired (String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration (String token) {
        return getClaim(token, Claims::getExpiration);
    }
}
