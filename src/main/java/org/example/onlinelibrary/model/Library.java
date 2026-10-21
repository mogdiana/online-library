package org.example.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
}
