package components;

import javax.swing.*;
import java.awt.*;

public class AssignmentCard extends JPanel {
    private final String courseName;
    private final String assignmentName;
    private final String deadline;

    public AssignmentCard(String courseName, String assignmentName, String deadline) {
        this.courseName = courseName;
        this.assignmentName = assignmentName;
        this.deadline = deadline;

//        JPanel card = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel courseLabel = new JLabel("Course: " + courseName);
        JLabel assignmentLabel = new JLabel("Assignment: " + assignmentName);
        JLabel deadlineLabel = new JLabel("Deadline: " + deadline);

        this.add(courseLabel);
        this.add(assignmentLabel);
        this.add(deadlineLabel);

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Show additional info on hover (if needed)
                deadlineLabel.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Hide additional info when not hovered
                deadlineLabel.setVisible(false);
            }
        });
    }
}
