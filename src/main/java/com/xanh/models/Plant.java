package com.xanh.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String scientificName;

    public Plant(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    // For hibernate
    public Plant() {

    }
}
