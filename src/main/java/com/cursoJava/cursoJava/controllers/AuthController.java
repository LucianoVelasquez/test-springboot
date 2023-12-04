package com.cursoJava.cursoJava.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoJava.cursoJava.auth.AuthResponse;
import com.cursoJava.cursoJava.auth.LoginRequest;
import com.cursoJava.cursoJava.auth.RegisterRequest;
import com.cursoJava.cursoJava.services.AuthService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    
    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

            
            return ResponseEntity.ok(authService.login(request));
    }

    
    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse>  register(@RequestBody RegisterRequest request){

            return ResponseEntity.ok(authService.register(request));
    }
}
