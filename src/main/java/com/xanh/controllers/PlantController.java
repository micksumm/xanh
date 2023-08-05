package com.xanh.controllers;

import com.xanh.dal.IPlantRepository;
import com.xanh.models.domain.Plant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlantController {
    private IPlantRepository plantRepository;

    @PostMapping("/plant/create")
    public Plant createPlant(@RequestParam(value = "name") String name,
                             @RequestParam(value = "sciName") String scientificName) {
        Plant plant = new Plant(name, scientificName);

        plantRepository.create(plant.toEntity());

        return plant;
    }

//    @GetMapping("/plants")
//    public ArrayList<Plant> getPlants() {
//        return plants;
//    }
//
//    @GetMapping("/plant")
//    public Plant getPlant(@RequestParam(value = "name") String name) {
//        for (Plant plant : plants) {
//            if (plant.name.equals(name)) {
//                return plant;
//            }
//        }
//        return null;
//    }

//    @PutMapping("/plant/edit")
//    public Plant editPlant(@RequestBody UpdatePlantRequest request) {
//        for (Plant plant : plants) {
//            if (plant.name.equals(request.plantName)) {
//                plant.name = request.updatedPlant.name;
//                plant.scientificName = request.updatedPlant.scientificName;
//                return plant;
//            }
//        }
//        return null;
//    }
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
