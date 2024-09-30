package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImple implements AuthServices {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<?> login(LoginDTO loginDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterDTO registerDTO) {
        clientRepository.save(new Client(registerDTO.firstName(), registerDTO.lastName(), registerDTO.email(), passwordEncoder.encode(registerDTO.password())));
        return ResponseEntity.ok("ok");
    }
}
