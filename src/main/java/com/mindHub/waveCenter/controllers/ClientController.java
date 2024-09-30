package com.mindHub.waveCenter.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @GetMapping("/")
    public ResponseEntity<?> helllo(){
        return ResponseEntity.ok("hello");
    }



}
