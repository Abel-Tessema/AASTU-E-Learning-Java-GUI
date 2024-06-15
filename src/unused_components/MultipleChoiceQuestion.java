package unused_components;

import unused_models.Question;

import javax.swing.*;
import java.awt.*;

public class MultipleChoiceQuestion extends JPanel {
    public MultipleChoiceQuestion(Question question) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(Question.currentId + ") " + question.getQuestionText());

        JRadioButton[] choices = new JRadioButton[question.getMultipleChoices().size()];
        ButtonGroup buttonGroup = new ButtonGroup();

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new BoxLayout(choicesPanel, BoxLayout.Y_AXIS));
        choicesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        choicesPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        for (int i = 0; i < choices.length; i++) {
            choices[i] = new JRadioButton(question.getMultipleChoices().get(i));
            buttonGroup.add(choices[i]);
            choicesPanel.add(choices[i]);
        }

        this.add(questionLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(choicesPanel);
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
    }
}
