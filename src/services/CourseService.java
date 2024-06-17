package services;

import exceptions.CoursesFetchException;
import models.Course;
import util.AppContext;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    public List<Course> fetchAllCourses() throws CoursesFetchException {
        int departmentId = AppContext.getInstance().getLoggedInStudent().getDepartmentId();
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT id, code, name, description, image, year, semester, department_id " +
                "FROM course WHERE department_id = ?";

        try (
                Connection connection = Database.connect();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setInt(1, departmentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = new Course();
                    course.setId(resultSet.getInt("id"));
                    course.setCode(resultSet.getString("code"));
                    course.setName(resultSet.getString("name"));
                    course.setDescription(resultSet.getString("description"));
                    course.setImagePath(resultSet.getString("image"));
                    course.setYear(resultSet.getInt("year"));
                    course.setSemester(resultSet.getInt("semester"));
                    course.setDepartmentId(resultSet.getInt("department_id"));
                    courses.add(course);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CoursesFetchException();
        }

        return courses;
    }
}
