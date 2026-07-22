package com.cfg.petadoption.service;

import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        log.info("Retrieving all pets from the database");

        List<Pet> pets = petRepository.findAll();

        if (pets.isEmpty()) {
            log.warn("No pets were found in the database");
        }
        return pets;

    }

    public Pet addPet(Pet pet) {
        if (pet == null) {
            log.error("Cannot add a null pet");
            throw new IllegalArgumentException("Pet cannot be null");
        }

        log.info("Adding new pet: {}", pet.getName());
        return petRepository.save(pet);
    }

    public List<Pet> getPetsBySpecies(String species) {
        log.info("Searching for pets with species: {}", species);
        return petRepository.findBySpecies(species);
    }

    public Pet getPetById(Integer id) {
        log.info("Searching for pet with ID: {}", id);

        return petRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Pet with ID {} was not found", id);
                    return new RuntimeException("Pet not found");
                });
    }
}
