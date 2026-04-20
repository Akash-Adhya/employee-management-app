package com.ems.serviceimpl.auth;

import jakarta.servlet.http.Cookie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CookieService {
    @Value("${jwt.cookie.name}")
    private String cookieName;
    @Value("${jwt.cookie.http-only}")
    private boolean httpOnly;
    @Value("${jwt.cookie.secure}")
    private boolean secure;
    @Value("${jwt.cookie.max-age}")
    private int cookieMaxAge;

    public Cookie getRefreshTokenCookie(String refreshToken){
        Cookie cookie = new Cookie(cookieName,refreshToken);
        cookie.setHttpOnly(httpOnly);
        cookie.setPath("/");
        cookie.setMaxAge(cookieMaxAge);
        cookie.setSecure(secure);
        return cookie;
    }


    public Cookie deleteRefreshTokenCookie(){
        Cookie cookie = new Cookie(cookieName,null);
        cookie.setHttpOnly(httpOnly);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setSecure(secure);
        return cookie;
    }
}
