package controllers;

import models.Student;
import services.StudentService;
import util.AppContext;

public class StudentController {
    private final StudentService studentService = new StudentService();

    public boolean logIn(String email, String password) {
        Student student = studentService.logIn(email, password);
        if (student != null) {
            AppContext.getInstance().setLoggedInStudent(student);
            return true;
        }
        return false;
//        return email.equals("student") && password.equals("1234");
    }

    public void logOut() {
        AppContext.getInstance().setLoggedInStudent(null);
    }
}
