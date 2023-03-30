package com.proj.website.dto;

import com.proj.website.model.goods.Microphone;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MicrophoneDto {
    private String model;
    private int price;
    private String description;

    public static MicrophoneDto createMicrophoneDto(Microphone microphone){
        return new MicrophoneDto(microphone.getModel(), microphone.getPrice(), microphone.getDescription());
    }
}
