package layouts;

import components.AssignmentCard;

import javax.swing.*;
import java.awt.*;

public class AssignmentsPanel extends JPanel {
    public AssignmentsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add assignment cards (example)
        for (int i = 1; i <= 10; i++) {
            panel.add(new AssignmentCard("Course " + i, "Assignment " + i, "Deadline " + i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
