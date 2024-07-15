package com.craig.woodcock.fishcatchtracker.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "anglers")
public class Angler {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // Getters and Setters
    public Integer getId(String a) {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
