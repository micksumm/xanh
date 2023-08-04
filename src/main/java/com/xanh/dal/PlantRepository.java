package com.xanh.dal;

import com.xanh.models.Plant;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class PlantRepository {
    private final DataSource dataSource;

    public void createPlant(Plant plant) {
        String sql = "INSERT INTO plant (name, scientific_name) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, plant.getName());
            pstmt.setString(2, plant.getScientificName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
