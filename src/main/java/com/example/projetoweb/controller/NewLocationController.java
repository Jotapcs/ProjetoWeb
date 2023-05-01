package com.example.projetoweb.controller;

import com.example.projetoweb.dto.request.NewLocationRequestDto;
import com.example.projetoweb.dto.response.NewLocationResponseDto;
import com.example.projetoweb.dto.response.ReturnLocationResponse;
import com.example.projetoweb.service.Impl.NewLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new/location")
public class NewLocationController {

    @Autowired
    private NewLocationServiceImpl newLocationServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<ReturnLocationResponse> returnLocation(
            @PathVariable String id) throws Exception {
        ReturnLocationResponse response = newLocationServiceImpl.returnLocation(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReturnLocationResponse>> returnAllLocation() throws Exception {
        List<ReturnLocationResponse> response = newLocationServiceImpl.returnAllLocation();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<NewLocationResponseDto> newLocation(@RequestBody
    NewLocationRequestDto requestDto) throws Exception {
        NewLocationResponseDto responseDto = newLocationServiceImpl.newLocationService(requestDto);

        return ResponseEntity.ok(responseDto);
    }
}
