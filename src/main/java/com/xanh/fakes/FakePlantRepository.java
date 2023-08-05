package com.xanh.fakes;

import com.xanh.dal.IPlantRepository;
import com.xanh.models.entities.PlantEntity;

import java.util.HashMap;
import java.util.Map;

public class FakePlantRepository implements IPlantRepository {
    private Map<Long, PlantEntity> plants = new HashMap<>();

    @Override
    public void create(PlantEntity p) {
        plants.put(p.getId(), p);
    }
}
