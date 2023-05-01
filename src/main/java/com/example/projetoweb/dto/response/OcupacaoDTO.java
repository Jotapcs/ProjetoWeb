package com.example.projetoweb.dto.response;

import org.springframework.stereotype.Component;

@Component
public class OcupacaoDTO {

    private int clinicoGeral;
    private int uti;
    private int internato;
    private int prontoSocorro;

    public int getClinicoGeral() {
        return clinicoGeral;
    }

    public void setClinicoGeral(int clinicoGeral) {
        this.clinicoGeral = clinicoGeral;
    }

    public int getUti() {
        return uti;
    }

    public void setUti(int uti) {
        this.uti = uti;
    }

    public int getInternato() {
        return internato;
    }

    public void setInternato(int internato) {
        this.internato = internato;
    }

    public int getProntoSocorro() {
        return prontoSocorro;
    }

    public void setProntoSocorro(int prontoSocorro) {
        this.prontoSocorro = prontoSocorro;
    }
}
