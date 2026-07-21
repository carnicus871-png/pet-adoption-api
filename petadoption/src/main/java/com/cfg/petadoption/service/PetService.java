package com.cfg.petadoption.service;

import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();

    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }
public List <Pet> getPetsBySpecies(String species){
        return petRepository.findBySpecies(species);
}
}