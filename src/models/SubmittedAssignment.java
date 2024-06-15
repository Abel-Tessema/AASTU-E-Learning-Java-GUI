package models;

public class SubmittedAssignment {
    private int id;
    private String filePath;

    private int assignmentId;
    private int studentId;

    // ===== Constructors =====

    public SubmittedAssignment() {}

    public SubmittedAssignment(int id, String filePath, int assignmentId, int studentId) {
        this.id = id;
        this.filePath = filePath;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
