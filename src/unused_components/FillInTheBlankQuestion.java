package unused_components;

import components.CustomTextFieldPanel;
import unused_models.Question;

import javax.swing.*;
import java.awt.*;

public class FillInTheBlankQuestion extends JPanel {
    public FillInTheBlankQuestion(Question question) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(Question.currentId + ") " + question.getQuestionText());
//        JTextField textField = new JTextField(20);
        CustomTextFieldPanel textFieldPanel = new CustomTextFieldPanel(300, 40);

        this.add(questionLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(textFieldPanel);
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
    }
}
