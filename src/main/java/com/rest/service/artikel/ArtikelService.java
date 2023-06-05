package com.rest.service.artikel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dataaccess.model.artikel.ArtikelEntity;
import com.rest.dataaccess.repository.artikel.ArtikelRepository;

@Service
@Transactional
public class ArtikelService {
    @Autowired
    private ArtikelRepository artikelRepository;
    
    public ArtikelEntity attach(ArtikelEntity artikel) {
        var attachArtikel = artikelRepository.save(artikel);
        return attachArtikel;
    }
    
    public Optional<ArtikelEntity> findById(Integer id) {
        return artikelRepository.findById(id);
    }
    
    public Optional<ArtikelEntity> findByArtikelnr(String artikelnr) {
        return artikelRepository.findByArtikelnr(artikelnr);
    }
    
    public void delete(Integer id) {
        artikelRepository.deleteById(id);
    }
    
    public Iterable<ArtikelEntity> findAll() {
        return artikelRepository.findAll();
    }
}
