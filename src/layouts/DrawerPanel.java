package layouts;

import javax.swing.*;
import java.awt.*;

public class DrawerPanel extends JPanel {
    private final CardLayout cardLayout;
    private final JPanel mainContentPanel;

    public DrawerPanel(JPanel mainContentPanel, CardLayout cardLayout) {
        this.mainContentPanel = mainContentPanel;
        this.cardLayout = cardLayout;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton coursesButton = new JButton("Courses");
        JButton assignmentsButton = new JButton("Assignments");
        JButton examsButton = new JButton("Exams");
        JButton settingsButton = new JButton("Settings");

        coursesButton.addActionListener(e -> showPanel("Courses"));
        assignmentsButton.addActionListener(e -> showPanel("Assignments"));
        examsButton.addActionListener(e -> showPanel("Exams"));
        settingsButton.addActionListener(e -> showPanel("Settings"));

        JButton[] buttons = {coursesButton, assignmentsButton, examsButton, settingsButton};

        // Determine the maximum width
        int maxWidth = 0;
        for (JButton button : buttons) {
            maxWidth = Math.max(maxWidth, button.getPreferredSize().width);
        }

        // Set all buttons to the maximum width
        Dimension buttonSize = new Dimension(maxWidth, coursesButton.getPreferredSize().height);
        for (JButton button : buttons) {
            button.setPreferredSize(buttonSize);
            button.setMaximumSize(buttonSize);
            button.setMinimumSize(buttonSize);
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the buttons
            panel.add(button);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing between buttons
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void showPanel(String panelName) {
        cardLayout.show(mainContentPanel, panelName);
    }
}
