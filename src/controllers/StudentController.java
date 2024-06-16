package controllers;

import exceptions.DatabaseConnectionException;
import exceptions.IncorrectPasswordException;
import exceptions.InvalidEmailOrPasswordException;
import exceptions.UnmatchingPasswordsException;
import models.Student;
import services.StudentService;
import util.AppContext;

public class StudentController {
    private final StudentService studentService = new StudentService();

    public String logIn(String email, String password) {
        Student student;
        try {
            student = studentService.logIn(email, password);
            AppContext.getInstance().setLoggedInStudent(student);
            return "";
        } catch (DatabaseConnectionException | InvalidEmailOrPasswordException e) {
            return e.getMessage();
        }
//        if (student != null) {
//            return true;
//        }
//        return email.equals("student") && password.equals("1234");
    }

    public void logOut() {
        AppContext.getInstance().setLoggedInStudent(null);
    }

    public String changePassword(String oldPassword, String newPassword, String confirmPassword) {
        try {
            studentService.changePassword(oldPassword, newPassword, confirmPassword);
            return "";
        } catch (
                DatabaseConnectionException |
                IncorrectPasswordException |
                UnmatchingPasswordsException |
                IllegalStateException e
        ) {
            return e.getMessage();
        }
    }

    public boolean submitAssignment() { return true; }

    public boolean submitExam(String content, int examId) {
        return studentService.submitExam(content, examId);
    }
}
