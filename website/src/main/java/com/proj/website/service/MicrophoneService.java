package com.proj.website.service;

import com.proj.website.controller.MicrophoneController;
import com.proj.website.dto.MicrophoneDto;
import com.proj.website.model.goods.Microphone;
import com.proj.website.service.repository.MicrophoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MicrophoneService {

    private final MicrophoneRepository microphoneRepository;

    public MicrophoneService(MicrophoneRepository microphoneRepository) {
        this.microphoneRepository = microphoneRepository;
    }

    public List<MicrophoneDto> getAll(){
        List<MicrophoneDto> microphoneDtoList = new ArrayList<>();
        microphoneRepository.findAll().forEach(microphone -> microphoneDtoList.add(MicrophoneDto
                .createMicrophoneDto(microphone)));
        return microphoneDtoList;
    }

    // Delete microphone
    public void deleteMicrophone(long id){
        microphoneRepository.deleteById(id);
    }

    // Read microphone
    public MicrophoneDto readMicrophone(long id) {
        Microphone microphone = microphoneRepository.findById(id).orElse(null);
        if (microphone != null) {
            return MicrophoneDto.createMicrophoneDto(microphone);
        }
        return null;
    }

    // Create microphone




}