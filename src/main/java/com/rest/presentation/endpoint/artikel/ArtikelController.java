package com.rest.presentation.endpoint.artikel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataaccess.model.artikel.ArtikelEntity;
import com.rest.presentation.dto.artikel.ArtikelCreateDto;
import com.rest.presentation.dto.artikel.ArtikelDto;
import com.rest.presentation.mapper.artikel.ArtikelMapper;
import com.rest.service.artikel.ArtikelService;

@RestController
@Validated
@RequestMapping(value = "/api/artikel")
public class ArtikelController {
    @Autowired
    private ArtikelService artikelService;

    @Autowired
    private ArtikelMapper mapper;
    
    @PostMapping
    public @Valid Integer create(@Valid @RequestBody ArtikelCreateDto dto) {
        ArtikelEntity artikel = mapper.toEntity(dto);
        
        return artikelService.attach(artikel).getId();
    }
    
    @PutMapping
    public void uopdate(@Valid @NotNull @RequestBody ArtikelDto dto) {
        Optional<ArtikelEntity> artikel = artikelService.findById(dto.getId());
        if (artikel.isPresent()) {
            ArtikelEntity art = mapper.toEntity(dto);
            
            artikelService.attach(art);
        }
    }
    
    @GetMapping
    public List<ArtikelDto> getArtikeln() {
        List<ArtikelDto> dtoList = new ArrayList<>();
        
        List<ArtikelEntity> artikelList = (List<ArtikelEntity>) artikelService.findAll();
        artikelList.stream().map(t -> mapper.toDto(t)).forEach(dtoList::add);
        
        return dtoList;
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ArtikelDto> getArtikel(@PathVariable(name = "id", required = true) Integer id) {
        Optional<ArtikelEntity> artikel = artikelService.findById(id);
        
        if (artikel.isPresent()) {
            return ResponseEntity.ok(mapper.toDto(artikel.get()));
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping(value = "/artikelnr/{artikelnr}")
    public ResponseEntity<ArtikelDto> getArtikelByArtikelnr(@PathVariable(name = "artikelnr", required = true) String artikelnr) {
        Optional<ArtikelEntity> artikel = artikelService.findByArtikelnr(artikelnr);
        
        if (artikel.isPresent()) {
            return ResponseEntity.ok(mapper.toDto(artikel.get()));
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id", required = true) Integer id) {
        artikelService.delete(id);
    }
}
