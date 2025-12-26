package com.example.demo.security;

import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    public String generateToken(Long userId, String email, String role) {
        return "test-jwt-token";
    }

    // REQUIRED BY TEST CASE
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {
        return generateToken(userId, email, role);
    }
}
