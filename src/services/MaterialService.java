package services;

import exceptions.CoursesFetchException;
import models.Material;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {
    public List<Material> fetchAllMaterials(int courseId) throws CoursesFetchException {
        List<Material> materials = new ArrayList<>();
        String query = "SELECT id, name, path, course_id FROM material WHERE course_id = ?";

        try (
                Connection connection = Database.connect();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {

            statement.setInt(1, courseId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String filePath = resultSet.getString("path");
                    int fetchedCourseId = resultSet.getInt("course_id");

                    Material material = new Material(id, name, filePath, fetchedCourseId);
                    materials.add(material);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CoursesFetchException();
        }

        return materials;
    }
}
