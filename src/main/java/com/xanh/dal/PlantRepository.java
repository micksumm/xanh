package com.xanh.dal;

import com.xanh.models.Plant;
import org.springframework.data.repository.CrudRepository;

// TODO: Make DAL model
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
