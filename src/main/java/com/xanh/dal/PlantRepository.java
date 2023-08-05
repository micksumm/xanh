package com.xanh.dal;

import com.xanh.models.entities.PlantEntity;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class PlantRepository implements IPlantRepository {
    private final DataSource dataSource;

    @Override
    public void create(PlantEntity p) {
        String sql = "INSERT INTO plant (name, scientific_name) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getScientificName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
