package com.xanh.models.domain;

import com.xanh.models.entities.PlantEntity;
import lombok.Getter;

public class Plant {
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String scientificName;

    public Plant(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    public Plant(PlantEntity pe) {
        this.name = pe.getName();
        this.id = pe.getId();
        this.scientificName = pe.getScientificName();
    }

    public PlantEntity toEntity() {
        return new PlantEntity(id, name, scientificName);
    }


}
