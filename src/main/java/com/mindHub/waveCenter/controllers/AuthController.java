package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.DTO.ClientDTO;
import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthServices authServices;

    @Autowired
    private ClientRepository clientRepository;


    @PostMapping("/login")
    public ResponseEntity<?> register(@RequestBody LoginDTO loginDTO) {
        return authServices.login(loginDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        return authServices.register(registerDTO);
    }
    @GetMapping("/current")
    public ResponseEntity<?> getClient(Authentication authentication) {
        return ResponseEntity.ok(new ClientDTO(clientRepository.findByEmail(authentication.getName())));
    }
}
