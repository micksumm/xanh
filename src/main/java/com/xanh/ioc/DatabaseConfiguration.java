package com.xanh.ioc;

import com.xanh.PlantController;
import com.xanh.dal.PlantRepository;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public PlantRepository plantRepository() {
        return new PlantRepository(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.url("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.username("mydbuser");
        dataSource.password("mydbpassword");
        var res = dataSource.build();

        return res;
    }

//    // TODO: Move into ControllerConfiguration
//    @Bean
//    public PlantController plantControllers() {
//        return new PlantController(plantRepository());
//    }
}
