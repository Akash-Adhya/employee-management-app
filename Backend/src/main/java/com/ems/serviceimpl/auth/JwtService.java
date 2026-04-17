package com.ems.serviceimpl.auth;

import com.ems.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.access.expiration}")
    private long accessExpiration;

    @Value("${jwt.refresh.expiration}")
    private long refreshExpiration;

    public SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateAccessToken(User user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("email",user.getEmail());
        claims.put("employeeId",user.getEmployeeId());
        claims.put("role",user.getRole());
        claims.put("typ","accessToken");
        return generateToken(accessExpiration,claims);
    }
    public String generateRefreshToken(User user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("employeeId",user.getEmployeeId());
        claims.put("typ","refreshToken");
        return generateToken(refreshExpiration,claims);
    }

    public boolean isTokenExpire(String token){
        Date expiration = getAllClaim(token).getExpiration();
        return expiration.before(new Date());
    }

    public boolean isAccessToken(String token){
        return "accessToken".equals(getAllClaim(token).get("typ",String.class));
    }

    public boolean isRefreshToken(String token){
        return "refreshToken".equals(getAllClaim(token).get("typ",String.class));
    }

    public String extractEmail(String token){
        if(!isAccessToken(token)) return null;
        return getAllClaim(token).get("email",String.class);
    }

    public String extractEmployeeId(String token){
        return getAllClaim(token).get("employeeId",String.class);
    }

    public String extractRole(String token){
        if(!isAccessToken(token)) return null;
        return getAllClaim(token).get("role",String.class);
    }

    private Claims getAllClaim(String token){
        return Jwts.parser().verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private String generateToken(long expiration, Map<String,Object> claims){
        String employeeId = claims.get("employeeId").toString();
        return Jwts.builder()
                .claims(claims)
                .subject(employeeId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSignInKey())
                .compact();
    }
}
