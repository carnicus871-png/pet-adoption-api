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

    public <T> boolean isNull(T item) {
        return item == null;
    }

    // Gets all pets from the database.
    public List<Pet> getAllPets() {
        log.info("Retrieving all pets from the database");

        List<Pet> pets = petRepository.findAll();

        if (pets.isEmpty()) {
            log.warn("No pets were found in the database");
        }
        return pets;

    }

    // Saves a new pet.
    public Pet addPet(Pet pet) throws IllegalArgumentException {
        if (isNull(pet)) {
            log.error("Cannot add a null pet");
            throw new IllegalArgumentException("Pet cannot be null");
        }
        log.info("Adding new pet: {}", pet.getName());

        try {
            return petRepository.save(pet);
        } catch (Exception e) {
            log.error("Error saving pet", e);
            throw new RuntimeException("Unable to save pet", e);
        }

    }

    // Finds pets that match the requested species
    public List<Pet> getPetsBySpecies(String species) {
        log.info("Searching for pets with species: {}", species);
        List<Pet> pets = petRepository.findAll();
        return pets.stream()
                .filter(pet -> pet.getSpecies().equalsIgnoreCase(species))
                .toList();
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
