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
}
