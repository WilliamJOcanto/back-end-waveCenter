package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthServices {

    ResponseEntity<?> login(LoginDTO loginDto);

    ResponseEntity<?> register(RegisterDTO registerDTO);
}
