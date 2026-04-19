package com.study.prhrsystem.controller;

import com.study.prhrsystem.dto.AuthResponseDTO;
import com.study.prhrsystem.dto.LoginDTO;
import com.study.prhrsystem.dto.RegisterDTO;
import com.study.prhrsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO request) {
        if (authService.emailExists(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        authService.createUser(request.getEmail(), request.getPassword(), request.getFullName());
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        try {
            String token = authService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(new AuthResponseDTO(token));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}