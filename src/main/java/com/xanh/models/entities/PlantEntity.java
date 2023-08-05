package com.xanh.models.entities;

import lombok.Getter;

public class PlantEntity {
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String scientificName;

    public PlantEntity(Long id, String name, String scientificName) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
    }
}
