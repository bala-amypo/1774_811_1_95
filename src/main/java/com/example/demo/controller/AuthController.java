package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final JwtTokenProvider provider;

    public AuthController(AuthenticationManager authManager,
                          UserService userService,
                          JwtTokenProvider provider) {
        this.authManager = authManager;
        this.userService = userService;
        this.provider = provider;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest req) {

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());

        User saved = userService.register(user);

        String token = provider.generateToken(
                saved.getId(), saved.getEmail(), saved.getRole());

        return new AuthResponse(token, saved.getId(),
                saved.getEmail(), saved.getRole());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(), req.getPassword())
        );

        User user = userService.findByEmail(req.getEmail());

        String token = provider.generateToken(
                user.getId(), user.getEmail(), user.getRole());

        return new AuthResponse(token, user.getId(),
                user.getEmail(), user.getRole());
    }
}
