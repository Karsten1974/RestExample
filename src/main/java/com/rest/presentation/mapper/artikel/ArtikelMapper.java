package com.rest.presentation.mapper.artikel;

import org.mapstruct.Mapper;

import com.rest.dataaccess.model.artikel.ArtikelEntity;
import com.rest.presentation.dto.artikel.ArtikelCreateDto;
import com.rest.presentation.dto.artikel.ArtikelDto;

@Mapper(componentModel = "spring")
public interface ArtikelMapper {
    
    ArtikelDto toDto(ArtikelEntity artikel);
    
    ArtikelEntity toEntity(ArtikelCreateDto dto);
    
    ArtikelEntity toEntity(ArtikelDto dto);
}
