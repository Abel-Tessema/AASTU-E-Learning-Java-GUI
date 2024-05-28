package components;

import javax.swing.*;
import java.awt.*;

public class ExamCard extends JPanel {
    private final String examName;
    private final String examDate;

    public ExamCard(String examName, String examDate) {
        this.examName = examName;
        this.examDate = examDate;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel examLabel = new JLabel("Exam: " + examName);
        JLabel dateLabel = new JLabel("Date: " + examDate);

        this.add(examLabel);
        this.add(dateLabel);
    }
}
