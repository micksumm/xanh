package com.xanh.ioc;

import com.xanh.dal.IPlantRepository;
import com.xanh.dal.PlantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAccessLayerConfiguration {
    private final DatabaseConfiguration dataSource;

    public DataAccessLayerConfiguration(DatabaseConfiguration dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public IPlantRepository plantRepository() {
        return new PlantRepository(dataSource.dataSource());
    }

}
