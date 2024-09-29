package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import com.mindHub.waveCenter.services.AuthServices;
import org.springframework.http.ResponseEntity;

public class AuthServiceImple implements AuthServices {
    @Override
    public ResponseEntity<?> login(LoginDTO loginDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterDTO registerDTO) {
        return null;
    }
}
