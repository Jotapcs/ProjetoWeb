package com.example.projetoweb.service.Impl;

import com.example.projetoweb.dto.request.NewLocationRequestDto;
import com.example.projetoweb.dto.response.NewLocationResponseDto;
import com.example.projetoweb.dto.response.ReturnLocationResponse;
import com.example.projetoweb.Database;
import com.example.projetoweb.service.NewLocationService;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewLocationServiceImpl implements NewLocationService {

    @Override
    public NewLocationResponseDto newLocationService(NewLocationRequestDto requestDto) throws Exception{
        if (requestDto.getComplement().isEmpty() || requestDto.getName().isEmpty() ||
        requestDto.getDescription().isEmpty() || requestDto.getNumber().isEmpty() || requestDto.getStreet().isEmpty()){
            throw new Exception("Complete todos os campos");
        } else {
            inserirNewLocation(requestDto);
            NewLocationResponseDto newLocationResponseDto = new NewLocationResponseDto();
            newLocationResponseDto.setText("Ok");
            return newLocationResponseDto;
        }
    }

    public void inserirNewLocation(NewLocationRequestDto requestDto) throws Exception{

        String sql = "INSERT INTO newLocation(name, street, number, complement, description) VALUES (?,?,?,?,?);";

        try (PreparedStatement ps = Database.connect().prepareStatement(sql)) {
            ps.setString(1, requestDto.getName());
            ps.setString(2, requestDto.getStreet());
            ps.setString(3, requestDto.getNumber());
            ps.setString(4, requestDto.getComplement());
            ps.setString(5, requestDto.getDescription());

            ps.execute();
        }
    }

    public ReturnLocationResponse returnLocation(String id) throws Exception {

        String sql = "SELECT * from newlocation where id = " + id;
        ReturnLocationResponse returnLocationResponse = new ReturnLocationResponse();
        try (PreparedStatement ps = Database.connect().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                returnLocationResponse.setId(rs.getInt("id"));
                returnLocationResponse.setName(rs.getString("name"));
                returnLocationResponse.setStreet(rs.getString("street"));
                returnLocationResponse.setNumber(rs.getString("number"));
                returnLocationResponse.setComplement(rs.getString("complement"));
                returnLocationResponse.setDescription(rs.getString("description"));
            }
        }
        return returnLocationResponse;
    }

    public List<ReturnLocationResponse> returnAllLocation() throws Exception {

        String sql = "SELECT * from newlocation";
        List<ReturnLocationResponse> returnLocationResponseList = new ArrayList<>();
        try (PreparedStatement ps = Database.connect().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ReturnLocationResponse returnLocationResponse = new ReturnLocationResponse();
                returnLocationResponse.setId(rs.getInt("id"));
                returnLocationResponse.setName(rs.getString("name"));
                returnLocationResponse.setStreet(rs.getString("street"));
                returnLocationResponse.setNumber(rs.getString("number"));
                returnLocationResponse.setComplement(rs.getString("complement"));
                returnLocationResponse.setDescription(rs.getString("description"));

                returnLocationResponseList.add(returnLocationResponse);

            }
        }
        return returnLocationResponseList;
    }
}
