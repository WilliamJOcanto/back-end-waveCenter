package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.ClientDTO;
import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface AuthServices {

    ResponseEntity<?> login(LoginDTO loginDto);

    ResponseEntity<?> register(RegisterDTO registerDTO);

    ResponseEntity<ClientDTO> getClient(Authentication authentication);

}
