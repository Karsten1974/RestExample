package com.rest.dataaccess.model.artikel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity(name="artikel")
public class ArtikelEntity {
    @GeneratedValue @Id
    private Integer id;
    
    @Version
    private int version;
    
    @Size(max = 15)
    @Column(length = 15, unique = true)
    private String artikelnr;

    @Size(max = 50)
    @Column(length = 50)
    private String bezeichnung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

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
