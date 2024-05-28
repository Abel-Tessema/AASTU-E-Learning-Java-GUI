package layouts;

import components.ExamCard;

import javax.swing.*;
import java.awt.*;

public class ExamsPanel extends JPanel {
    public ExamsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add exam cards (example)
        for (int i = 1; i <= 5; i++) {
            panel.add(new ExamCard("Exam " + i, "Date " + i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
