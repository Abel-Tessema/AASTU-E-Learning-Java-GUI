package models;

import java.awt.*;
import java.util.ArrayList;

public class Course {
    private String name;
    private String description;
    private String code;
    private Image image;
    private int year;
    private int semester;
    private ArrayList<Assignment> assignments;
    private ArrayList<Exam> exams;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public Image getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    // ===== Setters =====


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }
}
