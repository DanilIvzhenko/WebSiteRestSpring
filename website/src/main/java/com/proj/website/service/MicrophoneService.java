package com.proj.website.service;

import com.proj.website.model.goods.Microphone;
import com.proj.website.service.repository.MicrophoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MicrophoneService {
    @Autowired
    MicrophoneRepository microphoneRepository;
    public String createMicrophone(){
        Microphone microphone = new Microphone();
        /**microphone.setPrice(1000);
        microphone.setDescription("This is a microphone");
        microphone.setModel("Model 1");
        microphoneRepository.save(microphone);
        return microphone.toString();*/
        return null;
    }
}
