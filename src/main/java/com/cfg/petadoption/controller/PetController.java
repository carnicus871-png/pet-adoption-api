package com.cfg.petadoption.controller;

import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    @Value("${app.name}")
    private String appName;
    // Looks up a pet using its unique ID.
    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return petService.getPetById(id);
    }
    // Returns every pet currently in the catalogue.
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
    // Adds a new pet to the database.
    @PostMapping("/pets")
    public Pet newPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }
    // Filters pets by species
    @GetMapping("/pets/search")
    public List<Pet> searchPets(@RequestParam String species) {
        return petService.getPetsBySpecies(species);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the " + appName;
    }
}