package com.cfg.petadoption.service;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        log.info("Retrieve all pets from the database");
        return petRepository.findAll();
    }

    public Pet addPet(Pet pet) {
        log.info("Add new pet : {}", pet.getName());
        return petRepository.save(pet);
    }

    public List<Pet> getPetsBySpecies(String species) {
        log.info("Searching for pets with species: {}", species);
        return petRepository.findBySpecies(species);
    }
}