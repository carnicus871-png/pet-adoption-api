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

    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return petService.getPetById(id);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping("/pets")
    public Pet newPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @GetMapping("/pets/search")
    public List<Pet> searchPets(@RequestParam String species) {
        return petService.getPetsBySpecies(species);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the " + appName;
    }
}