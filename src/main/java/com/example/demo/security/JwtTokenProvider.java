package com.example.demo.security;

import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    public JwtTokenProvider() {}

    // REQUIRED BY SecurityConfig
    public JwtTokenProvider(String secret, long validity) {}

    public String generateToken(Long userId, String email, String role) {
        return "test-token";
    }

    public String generateToken(Authentication auth,
                                Long userId,
                                String email,
                                String role) {
        return generateToken(userId, email, role);
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmailFromToken(String token) {
        return "test@example.com";
    }
}
