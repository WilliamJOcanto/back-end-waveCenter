package com.mindHub.waveCenter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/event")
public class EventController {

    @GetMapping("/")
    public String getEvents() {
        return "event";
    }
}
