package com.proj.website.controller;

import com.proj.website.service.MicrophoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Microphone")
public class MicrophoneController {
    @Autowired
    MicrophoneService microphoneService;
    @GetMapping
    public String createMicrophone(){
        return microphoneService.createMicrophone();
    }
}
