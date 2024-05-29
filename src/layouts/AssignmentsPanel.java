package layouts;

import components.AssignmentCard;

import javax.swing.*;
import java.awt.*;

public class AssignmentsPanel extends JPanel {
    public AssignmentsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add assignment cards (example)
        for (int i = 1; i <= 10; i++) {
            panel.add(new AssignmentCard("Course " + i, "Assignment " + i, "Deadline " + i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
