package com.example.projetoweb.controller;

import com.example.projetoweb.dto.response.OcupacaoDTO;
import com.example.projetoweb.dto.response.ResponseOK;
import com.example.projetoweb.service.Impl.OcupacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private OcupacaoServiceImpl ocupacaoService;

    @GetMapping
    public ResponseEntity<OcupacaoDTO> getOcupacao() throws Exception {
        OcupacaoDTO response = ocupacaoService.buscarOcupacao();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseOK> addOcupacao(@RequestBody OcupacaoDTO ocupacaoDTO) throws Exception {
        ResponseOK response = ocupacaoService.addOcupacao(ocupacaoDTO);

        return ResponseEntity.ok(response);
    }
}
