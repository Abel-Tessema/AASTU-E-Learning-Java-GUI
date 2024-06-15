package models;

import java.time.LocalDateTime;

public class Exam {
    private int id;
    private String description;
    private double weight;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String courseId;

    // Constructors

    public Exam() {}

    public Exam(
            int id,
            String description,
            double weight,
            String content,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            String courseId
    ) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.content = content;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.courseId = courseId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getCourseId() {
        return courseId;
    }

    // ===== Setters =====


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
