package components;

import models.Question;

import javax.swing.*;
import java.awt.*;

public class WorkoutQuestion extends JPanel {
    public WorkoutQuestion(Question question) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(question.getId() + ") " + question.getQuestionText());
        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        CustomTextAreaPanel textAreaPanel = new CustomTextAreaPanel(400, 300);

        this.add(questionLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(textAreaPanel);
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
    }
}
