package models.requests;

import models.Plant;

public class UpdatePlantRequest {
    public String plantName;
    public Plant updatedPlant;

    public UpdatePlantRequest(String plantName, Plant updatedPlant) {
        this.plantName = plantName;
        this.updatedPlant = updatedPlant;
    }
}