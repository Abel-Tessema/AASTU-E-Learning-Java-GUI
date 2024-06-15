package util;

import models.Student;

public class AppContext {
    private static AppContext instance;
    private Student loggedInStudent;
    private String loginError = "";

    private AppContext() {
        // private constructor to prevent instantiation
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public Student getLoggedInStudent() {
        return loggedInStudent;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoggedInStudent(Student loggedInStudent) {
        this.loggedInStudent = loggedInStudent;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }
}

