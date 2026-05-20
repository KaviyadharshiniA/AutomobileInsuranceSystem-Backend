package com.example.insurance.security;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.
UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.
SecurityContextHolder;

import org.springframework.security.core.userdetails.
UserDetails;

import org.springframework.security.web.authentication.
WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter
extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomUserDetailsService service;

    @Override
    protected void doFilterInternal(

            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)

            throws ServletException,
            IOException {

        String authHeader=
                request.getHeader(
                        "Authorization");

        String token=null;

        String email=null;

        if(authHeader!=null
                &&
                authHeader.startsWith(
                        "Bearer ")){

            token=
                    authHeader.substring(7);

            email=
                    jwtUtil.extractEmail(
                            token);

        }

        if(email!=null &&
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        ==null){

            UserDetails details=
                    service
                    .loadUserByUsername(
                            email);

            if(jwtUtil.validateToken(
                    token,
                    details.getUsername())){

                UsernamePasswordAuthenticationToken auth=
                        new UsernamePasswordAuthenticationToken(

                                details,
                                null,
                                details.getAuthorities());

                auth.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(auth);

            }

        }

        chain.doFilter(
                request,
                response);

    }

}