package components;

import screens.DashboardScreen;
import screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JPanel mainPanel;

    public Window() {
        this.setTitle("AASTU E-Learning");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(500, 400));
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel(new CardLayout());

        this.add(mainPanel);
        showScreen(new LoginScreen(this));
        this.setVisible(true);
    }

    public void showScreen(JPanel screen) {
        mainPanel.removeAll();
        mainPanel.add(screen);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
