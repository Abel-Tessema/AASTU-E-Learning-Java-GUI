package models;

public class SubmittedExam {
    private int id;
    private String content;

    private int examId;
    private int studentId;

    // ===== Constructors =====

    public SubmittedExam() {}

    public SubmittedExam(int id, String content, int examId, int studentId) {
        this.id = id;
        this.content = content;
        this.examId = examId;
        this.studentId = studentId;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getExamId() {
        return examId;
    }

    public int getStudentId() {
        return studentId;
    }

    // ===== Setters =====

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
