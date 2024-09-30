package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.ClientDTO;
import com.mindHub.waveCenter.DTO.LoginDTO;
import com.mindHub.waveCenter.DTO.RegisterDTO;
import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.services.AuthServices;
import com.mindHub.waveCenter.servicesSecurity.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthServices {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;



    @Override
    public ResponseEntity<?> login(LoginDTO loginDTO) {
        try {

            if (validateLogin(loginDTO) != null) {
                return new ResponseEntity<>(validateLogin(loginDTO), HttpStatus.BAD_REQUEST);
            }

            authenticate(loginDTO);
            return ResponseEntity.ok(generateToken(getUserDetailsService(loginDTO)));

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Email or password invalid", HttpStatus.BAD_REQUEST);
        }
    }

    public String validateLogin(LoginDTO loginDTO) {

        if (loginDTO.email().isEmpty() || loginDTO.password().isEmpty()) {
            return "Email or password invalid";
        }
        return null;
    }

    public void authenticate(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));
    }

    public String generateToken(UserDetails userDetails) {

        return jwtUtilService.generateToken(userDetails);
    }

    public UserDetails getUserDetailsService(LoginDTO loginDTO) {

        return userDetailsService.loadUserByUsername(loginDTO.email());
    }


    @Override
    public ResponseEntity<?> register(RegisterDTO registerDTO) {

        ResponseEntity<?> validationResponse = validateRegister(registerDTO);
        if (validationResponse != null) {
            return validationResponse;
        }

        saveClient(generateClient(registerDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> validateRegister(RegisterDTO registerDTO) {
        // Verifico si el correo ya existe
        if (clientRepository.findByEmail(registerDTO.email()) != null) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        if (registerDTO.firstName().isBlank()) {
            return new ResponseEntity<>("First name is required", HttpStatus.BAD_REQUEST);
        }

        if (registerDTO.lastName().isBlank()) {
            return new ResponseEntity<>("Last name is required", HttpStatus.BAD_REQUEST);
        }

        if (registerDTO.email().isBlank()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }

        if (registerDTO.password().isBlank()) {
            return new ResponseEntity<>("Password is required", HttpStatus.BAD_REQUEST);
        }

        if (registerDTO.password().length() < 8) {
            return new ResponseEntity<>("Password must be at least 8 characters long", HttpStatus.BAD_REQUEST);
        }

        if (!registerDTO.password().matches(".*[A-Z].*")) {
            return new ResponseEntity<>("Password must contain at least one uppercase letter", HttpStatus.BAD_REQUEST);
        }
        if (!registerDTO.password().matches(".*[a-z].*")) {
            return new ResponseEntity<>("Password must contain at least one lowercase letter", HttpStatus.BAD_REQUEST);
        }
        if (!registerDTO.password().matches(".*[0-9].*")) {
            return new ResponseEntity<>("Password must contain at least one number", HttpStatus.BAD_REQUEST);
        }
        if (!registerDTO.password().matches(".*[^a-zA-Z0-9].*")) {
            return new ResponseEntity<>("Password must contain at least one symbol", HttpStatus.BAD_REQUEST);
        }

        return null;
    }
    public Client generateClient(RegisterDTO registerDTO) {
        return new Client(registerDTO.firstName(), registerDTO.lastName(), registerDTO.email(), passwordEncoder.encode(registerDTO.password()));
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public ResponseEntity<ClientDTO> getClient(Authentication authentication) {
        Client client = clientRepository.findByEmail(authentication.getName());
        return ResponseEntity.ok(new ClientDTO(client));
    }
}