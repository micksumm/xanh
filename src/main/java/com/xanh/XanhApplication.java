package com.xanh;

import com.xanh.dal.PlantRepository;
import com.xanh.models.Plant;
import com.xanh.models.requests.UpdatePlantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class XanhApplication {
    @Autowired
    private PlantRepository plantRepository;
    private ArrayList<Plant> plants = new ArrayList<>();
    public static void main(String[] args) {
        SpringApplication.run(XanhApplication.class, args);
    }

    @PostMapping("/plant/create")
    public Plant createPlant(@RequestParam(value = "name") String name,
                              @RequestParam(value = "sciName") String scientificName) {
        Plant plant = new Plant(name, scientificName);
        plants.add(plant);

        // New
        plantRepository.save(plant);

        return plant;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Plant> getAllPLants() {
        // This returns a JSON or XML with the users
        return plantRepository.findAll();
    }

    @GetMapping("/plants")
    public ArrayList<Plant> getPlants() {
        return plants;
    }

    @GetMapping("/plant")
    public Plant getPlant(@RequestParam(value = "name") String name) {
        for (Plant plant : plants) {
            if (plant.name.equals(name)) {
                return plant;
            }
        }
        return null;
    }

    @PutMapping("/plant/edit")
    public Plant editPlant(@RequestBody UpdatePlantRequest request) {
        for (Plant plant : plants) {
            if (plant.name.equals(request.plantName)) {
                plant.name = request.updatedPlant.name;
                plant.scientificName = request.updatedPlant.scientificName;
                return plant;
            }
        }
        return null;
    }

    @DeleteMapping("/plant/delete")
    public ArrayList<Plant> deletePlant(@RequestParam(value = "name") String name) {
        for (Plant plant : plants) {
            if (plant.name.equals(name)) {
                plants.remove(plant);
            }
        }
        return plants;
    }

}
