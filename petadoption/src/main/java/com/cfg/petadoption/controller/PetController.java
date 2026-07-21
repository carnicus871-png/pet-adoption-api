package com.cfg.petadoption.controller;
import lombok.RequiredArgsConstructor;
import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

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
}