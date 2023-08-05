package com.xanh.models.requests;

import com.xanh.models.entities.PlantEntity;

public class UpdatePlantRequest {
    public Long id; // TODO: need ID and not the name
    public PlantEntity updatedPlant;

    public UpdatePlantRequest(Long id, PlantEntity updatedPlant) {
        this.id = id;
        this.updatedPlant = updatedPlant;
    }

    public Long getId() {
        return id;
    }

    public PlantEntity getUpdatedPlant() {
        return updatedPlant;
    }
}