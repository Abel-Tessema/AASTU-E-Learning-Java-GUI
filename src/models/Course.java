package models;

public class Course {
    private int id;
    private String code;
    private String name;
    private String description;
    private String imagePath;
    private int year;
    private int semester;

    private int departmentId;

    // ===== Constructors =====

    public Course() {}

    public Course(
            int id,
            String code,
            String name,
            String description,
            String imagePath,
            int year,
            int semester,
            int departmentId
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.year = year;
        this.semester = semester;
        this.departmentId = departmentId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
