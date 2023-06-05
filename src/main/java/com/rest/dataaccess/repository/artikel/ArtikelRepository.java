package com.rest.dataaccess.repository.artikel;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataaccess.model.artikel.ArtikelEntity;

@Repository
public interface ArtikelRepository extends CrudRepository<ArtikelEntity, Integer> {
    Optional<ArtikelEntity> findByArtikelnr(String artikelnr);
}
