package models;

import util.QuestionType;

import java.util.ArrayList;

public class Question {
    public static int currentId = 0;
    private final int id;
    private QuestionType questionType;
    private float marks;
    private String questionText;
    private ArrayList<String> multipleChoices = new ArrayList<>();
    // For true/false, radio buttons
    // For multiple choice, radio buttons
    // For fill in the blank, an ArrayList<JTextField>
    // For short answer, a JTextArea
    // For workout, a JTextArea

    public Question() {
        this.id = incrementCurrentId();
    }

    public int getId() {
        return id;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public float getMarks() {
        return marks;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getMultipleChoices() {
        return multipleChoices;
    }

    public static void setCurrentId(int currentId) {
        Question.currentId = currentId;
    }

    private static int incrementCurrentId() {
        return ++currentId;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setMultipleChoices(ArrayList<String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }
}
