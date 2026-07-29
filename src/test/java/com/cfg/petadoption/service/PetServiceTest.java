package com.cfg.petadoption.service;

import com.cfg.petadoption.entity.Pet;
import com.cfg.petadoption.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @Test
    void addPetValidPetReturnsSavedPet() {

        Pet pet = new Pet();
        pet.setName("Harold");
        pet.setSpecies("Cat");
        pet.setBreed("Domestic short hair");
        pet.setAge(10);
        pet.setAvailable(false);

        when(petRepository.save(pet))
                .thenReturn(pet);


        Pet result = petService.addPet(pet);

        assertEquals(pet, result);
    }

    @Test
    void addPetNullPetThrowsIllegalArgumentException() {
        Pet pet = null;
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    petService.addPet(pet);
                }
        );
    }


    @Test
    void getPetByIdExistingPetReturnsPet() {
        Integer id = 1;
        Pet pet = new Pet();
        pet.setName("Harold");
        pet.setSpecies("Cat");
        pet.setBreed("Domestic short hair");
        pet.setAge(10);
        pet.setAvailable(false);

        when(petRepository.findById(id))
                .thenReturn(Optional.of(pet));

        Pet result = petService.getPetById(id);

        assertEquals(pet, result);
    }

    @Test
    void getPetByIdPetDoesNotExistThrowsRuntimeException() {
        Integer id = 999;
        when(petRepository.findById(id)).
                thenReturn(Optional.empty());
        assertThrows(
                RuntimeException.class,
                () -> {
                    petService.getPetById(id);
                }
        );
    }

    @Test
    void getAllPetsReturnsAllPets() {
        // Arrange
        Pet pet1 = new Pet();
        pet1.setName("Harold");
        pet1.setSpecies("Cat");
        pet1.setBreed("Domestic short hair");
        pet1.setAge(10);
        pet1.setAvailable(false);

        Pet pet2 = new Pet();
        pet2.setName("Kibbles");
        pet2.setSpecies("Dog");
        pet2.setBreed("Dachshund");
        pet2.setAge(3);
        pet2.setAvailable(false);

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);

        when(petRepository.findAll())
                .thenReturn(pets);
        List<Pet> result = petService.getAllPets();


        assertEquals(pets, result);
    }

    @Test
    void getAllPetsReturnsNoPets() {
        when(petRepository.findAll()).thenReturn(new ArrayList<>());
        List<Pet> result = petService.getAllPets();
        assertTrue(result.isEmpty());
    }

    @Test
    void getPetsBySpeciesReturnsMatchingPets() {
        String species = "Cat";
        Pet pet1 = new Pet();
        pet1.setName("Harold");
        pet1.setSpecies("Cat");
        pet1.setBreed("Domestic short hair");
        pet1.setAge(10);
        pet1.setAvailable(false);

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);

        when(petRepository.findBySpecies(species))
                .thenReturn(pets);
        List<Pet> result = petService.getPetsBySpecies(species);

        assertEquals(pets, result);
    }

    @Test
    void getPetsBySpeciesReturnsEmptyListWhenNoPetsFound() {
        String species = "Rabbit";

        when(petRepository.findBySpecies(species))
                .thenReturn(new ArrayList<>());
        List<Pet> result = petService.getPetsBySpecies(species);
        assertTrue(result.isEmpty());
    }
}