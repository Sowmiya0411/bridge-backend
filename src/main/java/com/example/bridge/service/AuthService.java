package com.example.bridge.service;

import com.example.bridge.dto.AuthRequestDto;
import com.example.bridge.dto.AuthResponseDto;
import com.example.bridge.dto.RegisterRequestDto;
import com.example.bridge.entity.SystemUser;
import com.example.bridge.repository.SystemUserRepository;
import com.example.bridge.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final SystemUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(SystemUserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Register
    public AuthResponseDto register(RegisterRequestDto request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        SystemUser user = new SystemUser();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponseDto(
                user.getId(),
                token,
                user.getUsername(),
                user.getRole()
        );
    }

    // Login
    public AuthResponseDto login(AuthRequestDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SystemUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        return new AuthResponseDto(
                user.getId(),
                token,
                user.getUsername(),
                user.getRole()
        );
    }
}