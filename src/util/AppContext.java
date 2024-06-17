package util;

import models.Student;

public class AppContext {
    private static AppContext instance;
    private Student loggedInStudent;

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

    public void setLoggedInStudent(Student loggedInStudent) {
        this.loggedInStudent = loggedInStudent;
    }

}

