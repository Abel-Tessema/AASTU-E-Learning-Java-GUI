package models;

import java.time.LocalDateTime;

public class Assignment {
    private int id;
    private String title;
    private double weight;
    private String content;
    private LocalDateTime dateTimeGiven;
    private LocalDateTime deadline;

    private int courseId;

    // ===== Constructors =====

    public Assignment() {}

    public Assignment(
            int id,
            String title,
            double weight,
            String content,
            LocalDateTime dateTimeGiven,
            LocalDateTime deadline,
            int courseId
    ) {
        this.id = id;
        this.title = title;
        this.weight = weight;
        this.content = content;
        this.dateTimeGiven = dateTimeGiven;
        this.deadline = deadline;
        this.courseId = courseId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTimeGiven() {
        return dateTimeGiven;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public int getCourseId() {
        return courseId;
    }

    // ===== Setters =====


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateTimeGiven(LocalDateTime dateTimeGiven) {
        this.dateTimeGiven = dateTimeGiven;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
