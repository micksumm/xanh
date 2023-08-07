package com.xanh.models.entities;

import lombok.Getter;
import lombok.Setter;

public class PlantEntity {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String scientificName;

    public PlantEntity(Long id, String name, String scientificName) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
    }
}
