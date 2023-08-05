package com.xanh.controllers;

import com.xanh.dal.IPlantRepository;
import com.xanh.models.domain.Plant;
import com.xanh.models.entities.PlantEntity;
import com.xanh.models.requests.UpdatePlantRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlantController {
    private IPlantRepository plantRepository;

    @PostMapping("/plant/create")
    public PlantEntity createPlant(@RequestParam(value = "name") String name,
                             @RequestParam(value = "sciName") String scientificName) {
        Plant plant = new Plant(name, scientificName);

        return plantRepository.create(plant.toEntity());
    }

    @GetMapping("/plants")
    public List<PlantEntity> getPlants() {
        return plantRepository.getAllPlants();
    }

    @GetMapping("/plant")
    public PlantEntity getPlantById(@RequestParam(value = "id") Long id ) {
        return plantRepository.get(id);
    }

    @PutMapping("/plant/edit")
    public PlantEntity editPlant(@RequestBody UpdatePlantRequest request) {
        plantRepository.update(request);
        return request.getUpdatedPlant();
    }
//
//    @DeleteMapping("/plant/delete")
//    public ArrayList<Plant> deletePlant(@RequestParam(value = "name") String name) {
//        for (Plant plant : plants) {
//            if (plant.name.equals(name)) {
//                plants.remove(plant);
//            }
//        }
//        return plants;
//    }
}
