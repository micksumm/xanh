package com.xanh.controllers;

import com.xanh.fakes.FakePlantRepository;
import com.xanh.models.domain.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlantControllerTests {
    private String name = "Swiss Cheese";
    private String scientificName = "Monstera Deliciosa";

    private String name2 = "Chinese Evergreen";
    private String scientificName2 = "Aglaonema";

    private PlantController controller = new PlantController(new FakePlantRepository());

    @Test
    public void createPlant_Valid_SuccessfullyCreated() {
        Plant swissCheese = controller.createPlant(name, scientificName);

        assertEquals(name, swissCheese.getName());
        assertEquals(scientificName, swissCheese.getScientificName());
    }

//    @Test
//    public void getPlants_Valid_SuccessfullyRetrieved() {
//        Plant swissCheese = controller.createPlant(name, scientificName);
//        Plant chineseEvergreen = controller.createPlant(name2, scientificName2);
//
//        var plants = controller.getPlants();
//
//        assertEquals(2, plants.size());
//        assertEquals(swissCheese.name, plants.get(0).name);
//        assertEquals(chineseEvergreen.name, plants.get(1).name);
//    }
//
//    @Test
//    public void getPlant_Valid_SuccessfullyRetrieveOne() {
//        Plant swissCheese = controller.createPlant(name, scientificName);
//
//        var plant = controller.getPlant("Swiss Cheese");
//
//        assertEquals(swissCheese.name, plant.name);
//        assertEquals(swissCheese.scientificName, plant.scientificName);
//    }
//
//    @Test
//    public void editPlant_Valid_SuccessfullyEdited() {
//        Plant swissCheese = controller.createPlant(name, scientificName);
//        var updatedPlant = new Plant(name2, scientificName2);
//        var request = new UpdatePlantRequest(swissCheese.name, updatedPlant);
//
//        var editedPlant = controller.editPlant(request);
//
//        assertEquals(updatedPlant.name, editedPlant.name);
//        assertEquals(updatedPlant.scientificName, editedPlant.scientificName);
//    }
//
//    @Test
//    public void deletePlant_Valid_SuccessfullyDeleted() {
//        Plant swissCheese = controller.createPlant(name, scientificName);
//        Plant chineseEvergreen = controller.createPlant(name2, scientificName2);
//
//        var leftoverPlants = controller.deletePlant("Swiss Cheese");
//
//
//        assertEquals( 1, leftoverPlants.size());
//        assertEquals(chineseEvergreen.name, leftoverPlants.get(0).name);
//        assertEquals(chineseEvergreen.scientificName, leftoverPlants.get(0).scientificName);
//    }

}
