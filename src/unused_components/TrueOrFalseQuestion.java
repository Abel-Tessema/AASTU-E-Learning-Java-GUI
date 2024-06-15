package unused_components;

import unused_models.Question;

import javax.swing.*;
import java.awt.*;

public class TrueOrFalseQuestion extends JPanel {
    public TrueOrFalseQuestion(Question question) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(Question.currentId + ") " + question.getQuestionText());

        JRadioButton trueChoice = new JRadioButton("True");
        JRadioButton falseChoice = new JRadioButton("False");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(trueChoice);
        buttonGroup.add(falseChoice);

        JPanel trueOrFalseRadiosPanel = new JPanel();
        trueOrFalseRadiosPanel.setLayout(new BoxLayout(trueOrFalseRadiosPanel, BoxLayout.X_AXIS));
        trueOrFalseRadiosPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        trueOrFalseRadiosPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        trueOrFalseRadiosPanel.add(trueChoice);
        trueOrFalseRadiosPanel.add(falseChoice);

        this.add(questionLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(trueOrFalseRadiosPanel);
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
    }
}
