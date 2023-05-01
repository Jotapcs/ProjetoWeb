package com.example.projetoweb.dto.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseOK {

    private String text;

    public void setText(String text) {
        this.text = text;
    }
}
