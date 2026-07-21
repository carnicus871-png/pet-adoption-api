package com.cfg.petadoption.repository;

import com.cfg.petadoption.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
