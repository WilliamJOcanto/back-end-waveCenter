//package com.mindHub.waveCenter.controllers;
//
//import com.mindHub.waveCenter.DTO.ClientDTO;
//import com.mindHub.waveCenter.DTO.RegisterDTO;
//import com.mindHub.waveCenter.services.AuthServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Controller
//@RestController("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthServices authServices;
//    @PostMapping("/register")
//    public ResponseEntity<?> register(RegisterDTO registerDTO) {
//        return authServices.register(registerDTO);
//    }
//
//    @GetMapping("/current")
//    public ResponseEntity<?> getClient(Authentication authentication) {
//        return ResponseEntity.ok(new ClientDTO(clientRepository.findByEmail(authentication.getName())));
//    }
//}
