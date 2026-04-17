package com.ems.serviceimpl.auth;

import com.ems.entities.User;
import com.ems.repositories.UserRepo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String headerVar;

    @Value("${jwt.token-prefix}")
    private String prefixVar;


    private final JwtService jwtService;
    private final UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(headerVar);
        if(header == null || !header.startsWith(prefixVar+" ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = header.substring(prefixVar.length() + 1);
        try{
            if(!jwtService.isAccessToken(token) || jwtService.isTokenExpire(token)){
                filterChain.doFilter(request,response);
                return;
            }

            String employeeId = jwtService.extractEmployeeId(token);
            User user = userRepo.findByEmployeeId(employeeId)
                    .orElse(null);
            if(user == null){
                filterChain.doFilter(request,response);
                return;
            }

            if(
                    SecurityContextHolder
                            .getContext()
                            .getAuthentication() == null
            ){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                user.getAuthorities()
                        );
                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }

        }catch(ExpiredJwtException e){
            System.out.println("JWT expired");
        }catch(MalformedJwtException e){
            System.out.println("Invalid JWT");
        }catch(JwtException e){
            System.out.println("JWT error");
        }catch(Exception e){
            System.out.println("Authentication error");
        }

        filterChain.doFilter(request,response);
    }
}
