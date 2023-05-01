package com.example.projetoweb.service;

import com.example.projetoweb.dto.request.NewLocationRequestDto;
import com.example.projetoweb.dto.response.NewLocationResponseDto;

public interface NewLocationService {

    NewLocationResponseDto newLocationService(NewLocationRequestDto requestDto) throws Exception;
}
