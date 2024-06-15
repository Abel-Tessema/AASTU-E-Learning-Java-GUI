package services;

import models.Student;
import util.AppContext;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {
    public Student logIn(String email, String password) {
        String query = "SELECT * FROM student WHERE email = ? AND password = ?";

        try (
                Connection connection = Database.connect();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    AppContext.getInstance().setLoginError("");

                    Student student = new Student();
                    student.setId(resultSet.getString("id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setYear(resultSet.getInt("year"));
                    student.setSemester(resultSet.getInt("semester"));
                    student.setSection(resultSet.getString("section"));
                    student.setCollegeId(resultSet.getInt("college_id"));
                    student.setDepartmentId(resultSet.getInt("department_id"));

                    return student;
                } else {
                    AppContext.getInstance().setLoginError("Invalid email or password.");
                    return null;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            AppContext.getInstance().setLoginError("Connection error.");
            return null;
        }
    }
}
