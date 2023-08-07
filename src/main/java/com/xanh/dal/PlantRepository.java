package com.xanh.dal;

import com.xanh.models.entities.PlantEntity;
import com.xanh.models.requests.UpdatePlantRequest;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlantRepository implements IPlantRepository {
    private final DataSource dataSource;

    @Override
    public PlantEntity create(PlantEntity p) {
        String sql = "INSERT INTO plant (name, scientific_name) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getScientificName());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
                    p.setId(generatedId); // Set the generated ID back to the entity
                    return p;
                } else {
                    throw new SQLException("Inserting entity failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public List<PlantEntity> getAllPlants() {
        List<PlantEntity> plants = new ArrayList<>();
        String sql = "SELECT id, name, scientific_name FROM plant";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String scientificName = rs.getString("scientific_name");
                plants.add(new PlantEntity(id, name, scientificName));
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }

        return plants;
    }

    public PlantEntity get(Long id) {
        String sql = "SELECT name, scientific_name FROM plant WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String scientificName = rs.getString("scientific_name");
                    return new PlantEntity(id, name, scientificName);
                }
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }

        return null; // Return null if the record with the specified id is not found
    }

    public void update(UpdatePlantRequest request) {
        String sql = "UPDATE plant SET name = ?, scientific_name = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, request.getUpdatedPlant().getName());
            pstmt.setString(2, request.getUpdatedPlant().getScientificName());
            pstmt.setLong(3, request.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}

