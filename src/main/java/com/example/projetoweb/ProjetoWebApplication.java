package com.example.projetoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjetoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoWebApplication.class, args);
    }

}
