package layouts;

import components.*;
import models.Question;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CoursesPanel extends JPanel {
    public CoursesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add course cards (example)
        for (int i = 1; i <= 5; i++) {
            panel.add(new CourseCard("Course " + i));
        }

        Question question = new Question();
        question.setQuestionText("Mukera 123");
//        ArrayList<String> choices = new ArrayList<>();
//        choices.add("Mukera 1");
//        choices.add("Mukera 2");
//        choices.add("Mukera 3");
//        choices.add("Mukera 4");
//        question.setMultipleChoices(choices);
        FillInTheBlankQuestion questionCard = new FillInTheBlankQuestion(question);
        panel.add(questionCard);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
