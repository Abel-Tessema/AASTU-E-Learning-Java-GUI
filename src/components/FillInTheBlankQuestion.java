package components;

import models.Question;

import javax.swing.*;
import java.awt.*;

public class FillInTheBlankQuestion extends JPanel {
    public FillInTheBlankQuestion(Question question) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(question.getId() + ") " + question.getQuestionText());
//        JTextField textField = new JTextField(20);
        CustomTextFieldPanel textFieldPanel = new CustomTextFieldPanel();

        this.add(questionLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(textFieldPanel);
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
    }
}
