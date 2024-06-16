package screens;

import components.Window;
import layouts.*;

import javax.swing.*;
import java.awt.*;

public class DashboardScreen extends JPanel {
    private final Window window;
    private final CardLayout cardLayout;
    private final JPanel mainContentPanel;

    public DashboardScreen(Window window) {
        this.window = window;
        this.cardLayout = new CardLayout();
        this.mainContentPanel = new JPanel(cardLayout);

        this.setLayout(new BorderLayout());

        // Drawer Panel
        JPanel drawerPanel = new DrawerPanel(mainContentPanel, cardLayout);

        // Adding components to the main layout
        this.add(drawerPanel, BorderLayout.WEST);
        this.add(mainContentPanel, BorderLayout.CENTER);

        // Adding content panels to the CardLayout
        mainContentPanel.add(new CoursesPanel(mainContentPanel, cardLayout), "Courses");
        mainContentPanel.add(new AssignmentsPanel(mainContentPanel, cardLayout), "Assignments");
        mainContentPanel.add(new ExamsPanel(mainContentPanel, cardLayout), "Exams");
        mainContentPanel.add(new SettingsPanel(window), "Settings");
    }
}
