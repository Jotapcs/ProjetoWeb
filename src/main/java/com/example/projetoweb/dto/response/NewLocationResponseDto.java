package com.example.projetoweb.dto.response;

import org.springframework.stereotype.Component;

@Component
public class NewLocationResponseDto {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
