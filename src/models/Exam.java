package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exam {
    private String name;
    private String description;
    private String courseCode;
    private LocalDateTime dateTime;
    private ArrayList<Question> questions;
}
