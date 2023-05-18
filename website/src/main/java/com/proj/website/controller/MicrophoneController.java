package com.proj.website.controller;

import com.proj.website.dto.MicrophoneDto;
import com.proj.website.service.MicrophoneService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/microphone")
public class MicrophoneController {
    private final MicrophoneService microphoneService;

    public MicrophoneController(MicrophoneService microphoneService) {
        this.microphoneService = microphoneService;
    }

    // Create microphone
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MicrophoneDto>> createMicrophone(){
        return ResponseEntity.ok(microphoneService.getAll());
    }
    // Delete microphone
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteMicrophone(@PathVariable String id){
        microphoneService.deleteMicrophone(Long.parseLong(id));
    }

    // Read microphone
    @GetMapping(value = "/microphone/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MicrophoneDto> readMicrophone(@PathVariable String id) {
        MicrophoneDto microphoneDto = microphoneService.readMicrophone(Long.parseLong(id));
        if (microphoneDto != null) {
            return ResponseEntity.ok(microphoneDto);
        }
        return ResponseEntity.notFound().build();
    }
}