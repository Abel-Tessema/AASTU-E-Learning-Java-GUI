package components;

import controllers.StudentController;
import models.Student;
import screens.DashboardScreen;
import screens.LoginScreen;
import util.AppContext;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final StudentController controller = new StudentController();
    private JPanel mainPanel;

    public Window() {
        this.setTitle("AASTU E-Learning");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(500, 400));
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel(new CardLayout());

        this.add(mainPanel);

        Student loggedInStudent = controller.loadLoggedInStudent();

        if (loggedInStudent != null) {
            AppContext.getInstance().setLoggedInStudent(loggedInStudent);
            this.showScreen(new DashboardScreen(this));
        } else {
            this.showScreen(new LoginScreen(this));
        }
        this.setVisible(true);
    }

    public void showScreen(JPanel screen) {
        mainPanel.removeAll();
        mainPanel.add(screen);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
