package com.xanh.dal;

import com.xanh.models.entities.PlantEntity;
import com.xanh.models.requests.UpdatePlantRequest;

import java.util.List;

public interface IPlantRepository {
    PlantEntity create(PlantEntity p);
    List<PlantEntity> getAllPlants();
    PlantEntity get(Long id);
    void update(UpdatePlantRequest request);
    boolean delete(Long id);
}
