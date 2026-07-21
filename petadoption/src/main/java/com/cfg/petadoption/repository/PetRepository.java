package com.cfg.petadoption.repository;

import com.cfg.petadoption.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findBySpecies(String species);
}
