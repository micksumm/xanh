package com.xanh.models;

import lombok.Data;

@Data
public class Plant {
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
