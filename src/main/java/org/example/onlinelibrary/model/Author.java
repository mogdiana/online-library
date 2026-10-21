package org.example.onlinelibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(name="name")
    private String name;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @Column(name="death_date")
    private LocalDate deathDate;
}
