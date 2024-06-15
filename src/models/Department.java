package models;

public class Department {
    private int id;
    private String name;

    private int collegeId;

    // ===== Constructors =====

    public Department() {}

    public Department(int id, String name, int collegeId) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCollegeId() {
        return collegeId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
