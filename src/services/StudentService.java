package services;

import exceptions.DatabaseConnectionException;
import exceptions.IncorrectPasswordException;
import exceptions.InvalidEmailOrPasswordException;
import exceptions.UnmatchingPasswordsException;
import models.Student;
import models.SubmittedExam;
import util.AppContext;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {
    public Student logIn(String email, String password)
            throws DatabaseConnectionException, InvalidEmailOrPasswordException {
        String query = "SELECT * FROM student WHERE email = ? AND password = ?";

        try (
                Connection connection = Database.connect();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
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
                    throw new InvalidEmailOrPasswordException();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    public boolean submitExam(String content, int examId) {
        SubmittedExam submittedExam = new SubmittedExam();
        submittedExam.setContent(content);
        submittedExam.setStudentId(AppContext.getInstance().getLoggedInStudent().getId());
        submittedExam.setExamId(examId);

        // Define the SQL insert statement
        String sql = "INSERT INTO submitted_exam (content, exam_id, student_id) VALUES (?, ?, ?)";

        // Try-with-resources to ensure the connection and statement are closed properly
        try (
                Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, submittedExam.getContent());
            preparedStatement.setInt(2, submittedExam.getExamId());
            preparedStatement.setInt(3, submittedExam.getStudentId());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Return true if one row was inserted
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            // Return false if an exception occurred
            return false;
        }
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword)
            throws DatabaseConnectionException, IncorrectPasswordException, UnmatchingPasswordsException {

        // Get the logged-in student
        Student loggedInStudent = AppContext.getInstance().getLoggedInStudent();
        if (loggedInStudent == null) {
            throw new IllegalStateException("No student is currently logged in.");
        }

        int studentId = loggedInStudent.getId();

        // Step 1: Verify the old password
        try (Connection connection = Database.connect()) {
            String query = "SELECT password FROM student WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, studentId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        if (!storedPassword.equals(oldPassword)) {
                            throw new IncorrectPasswordException();
                        }
                    } else {
                        throw new IllegalStateException("User not found. Please try again or contact us.");
                    }
                }
            }

            // Step 2: Check if new password and confirm password match
            if (!newPassword.equals(confirmPassword)) {
                throw new UnmatchingPasswordsException();
            }

            // Step 3: Update the password in the database
            String updateQuery = "UPDATE student SET password = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, newPassword);
                statement.setInt(2, studentId);
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DatabaseConnectionException();
        }
    }
}
