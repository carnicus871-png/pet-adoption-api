package com.cfg.petadoption.service;

import lombok.RequiredArgsConstructor;
import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getPetsBySpecies(String species) {
        return petRepository.findBySpecies(species);
    }
}