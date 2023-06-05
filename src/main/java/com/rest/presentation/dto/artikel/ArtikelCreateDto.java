package com.rest.presentation.dto.artikel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtikelCreateDto {
    @NotBlank
    @NotNull
    @Size(max = 15)
    private String artikelnr;

    @Size(max = 50)
    private String bezeichnung;
    
    public String getArtikelnr() {
        return artikelnr;
    }

    public void setArtikelnr(String artikelnr) {
        this.artikelnr = artikelnr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

}
