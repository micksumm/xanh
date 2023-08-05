package com.xanh.models.requests;

import com.xanh.models.domain.Plant;

public class UpdatePlantRequest {
    public String plantName;
    public Plant updatedPlant;

    public UpdatePlantRequest(String plantName, Plant updatedPlant) {
        this.plantName = plantName;
        this.updatedPlant = updatedPlant;
    }
}