package com.odp.walled.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import lombok.Getter;

@Configuration
@Getter
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

}
