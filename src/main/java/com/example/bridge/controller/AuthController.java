package com.example.bridge.controller;

import com.example.bridge.dto.AuthRequestDto;
import com.example.bridge.dto.AuthResponseDto;
import com.example.bridge.dto.RegisterRequestDto;
import com.example.bridge.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(
            @Valid @RequestBody RegisterRequestDto registerDto) {

        return ResponseEntity.ok(authService.register(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @Valid @RequestBody AuthRequestDto authRequestDto) {

        return ResponseEntity.ok(authService.login(authRequestDto));
    }
}