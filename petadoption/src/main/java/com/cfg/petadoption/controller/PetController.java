package com.cfg.petadoption.controller;

import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping("/pets")
    public Pet newPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }
}