package com.xanh.fakes;

import com.xanh.dal.IPlantRepository;
import com.xanh.models.entities.PlantEntity;
import com.xanh.models.requests.UpdatePlantRequest;

import java.util.*;
import java.util.stream.Collectors;

public class FakePlantRepository implements IPlantRepository {
    private Map<Long, PlantEntity> plants = new HashMap<>();
    private Long id = 0L;

    @Override
    public PlantEntity create(PlantEntity p) {
        p.setId(id);
        plants.put(id, p);
        id++;

        return p;
    }

    @Override
    public List<PlantEntity> getAllPlants() {
        return plants
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public PlantEntity get(Long id) {
        return plants.get(id);
    }

    @Override
    public void update(UpdatePlantRequest request) {
        var plantToUpdate = get(request.getId());
        plantToUpdate.setName(request.getUpdatedPlant().getName());
        plantToUpdate.setScientificName(request.getUpdatedPlant().getScientificName());

        plants.replace(plantToUpdate.getId(), plantToUpdate);
    }
}
