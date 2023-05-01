package com.example.projetoweb.service.Impl;

import com.example.projetoweb.Database;
import com.example.projetoweb.dto.request.NewLocationRequestDto;
import com.example.projetoweb.dto.response.OcupacaoDTO;
import com.example.projetoweb.dto.response.ResponseOK;
import com.example.projetoweb.dto.response.ReturnLocationResponse;
import com.example.projetoweb.service.OcupacaoService;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class OcupacaoServiceImpl implements OcupacaoService {

    @Override
    public OcupacaoDTO buscarOcupacao() throws Exception{

        String sql = "SELECT * FROM ocupacao";

        OcupacaoDTO ocupacaoDTO = new OcupacaoDTO();
        try (PreparedStatement ps = Database.connect().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ocupacaoDTO.setClinicoGeral(rs.getInt("clinicoGeral"));
                ocupacaoDTO.setUti(rs.getInt("uti"));
                ocupacaoDTO.setInternato(rs.getInt("internato"));
                ocupacaoDTO.setProntoSocorro(rs.getInt("prontoSocorro"));
            }
        }
        return ocupacaoDTO;
    }

    public ResponseOK addOcupacao(OcupacaoDTO ocupacaoDTO) throws Exception {
            inserirPaciente(ocupacaoDTO);
            ResponseOK responseOK = new ResponseOK();
            responseOK.setText("OK");

            return responseOK;
    }

    public void inserirPaciente(OcupacaoDTO ocupacaoDTO) throws Exception {

        String sql1 = "SELECT * FROM ocupacao";
        String sql = "INSERT INTO ocupacao(clinicoGeral, uti, internato, prontoSocorro) VALUES (?,?,?,?);";

        PreparedStatement ps2 = Database.connect().prepareStatement(sql1);
        try (PreparedStatement ps = Database.connect().prepareStatement(sql)) {
            ResultSet rs = ps2.executeQuery();

            ps.setInt(1, ocupacaoDTO.getClinicoGeral());
            ps.setInt(2, ocupacaoDTO.getUti());
            ps.setInt(3, ocupacaoDTO.getInternato());
            ps.setInt(4, ocupacaoDTO.getProntoSocorro());

            ps.execute();

            while(rs.next()) {
                ocupacaoDTO.setClinicoGeral(rs.getInt("clinicoGeral"));
                ocupacaoDTO.setUti(rs.getInt("uti"));
                ocupacaoDTO.setInternato(rs.getInt("internato"));
                ocupacaoDTO.setProntoSocorro(rs.getInt("prontoSocorro"));
            }
        }
    }
}
