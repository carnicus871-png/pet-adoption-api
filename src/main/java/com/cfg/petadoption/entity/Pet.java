package com.cfg.petadoption.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

// Represents a pet stored in the database.
@Entity
@Table(name = "pets")

@Data
@NoArgsConstructor
public class Pet {
    // Automatically generated primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean available;
}