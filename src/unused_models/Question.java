package unused_models;

import util.QuestionType;

import java.util.ArrayList;

public class Question {
    public static int currentId = 0;

    private int id;
    private QuestionType questionType;
    private float marks;
    private String questionText;
    private ArrayList<String> multipleChoices = new ArrayList<>();

    public Question() {
        currentId++;
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
