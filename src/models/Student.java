package models;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int year;
    private int semester;
    private String section;

    private int collegeId;
    private int departmentId;

    // ===== Constructors =====

    public Student() {}

    public Student(
            int id,
            String firstName,
            String lastName,
            String email,
            int year,
            int semester,
            String section,
            int collegeId,
            int departmentId
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.year = year;
        this.semester = semester;
        this.section = section;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public String getSection() {
        return section;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
