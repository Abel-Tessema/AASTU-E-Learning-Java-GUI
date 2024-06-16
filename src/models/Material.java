package models;

public class Material {
    private int id;
    private String name;
    private String filePath;

    private int courseId;

    // ===== Constructors =====

    public Material() {}

    public Material(int id, String name, String filePath, int courseId) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
        this.courseId = courseId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getCourseId() {
        return courseId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
