package screens;

import components.Window;
import controllers.StudentController;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JPanel {
    private final JLabel welcomeMessage;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JButton logInButton;
    private final StudentController controller;
    private final Window window;

    public LoginScreen(Window window) {
        this.window = window;

        JPanel verticalPanel = new JPanel();
        JPanel emailPanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        welcomeMessage = new JLabel("Welcome to AASTU E-Learning.");
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));

        emailField = new JTextField(10);
        emailField.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));

        passwordField = new JPasswordField(10);

        logInButton = new JButton("Log In");
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logInButton.addActionListener(event -> logIn());

        controller = new StudentController();

        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(35, 0)));
        emailPanel.add(emailField);

        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        passwordPanel.add(passwordField);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(logInButton);
        buttonPanel.add(Box.createHorizontalGlue());

        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        verticalPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        verticalPanel.add(welcomeMessage);
        verticalPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        verticalPanel.add(emailPanel);
        verticalPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        verticalPanel.add(passwordPanel);
        verticalPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        verticalPanel.add(buttonPanel);

        this.add(verticalPanel);


//        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    private void logIn() {
        String email = this.emailField.getText();
        String password = new String(this.passwordField.getPassword());

        if (controller.logIn(email, password)) {
            window.showScreen(new DashboardScreen(window));
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid email or password. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
