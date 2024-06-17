package layouts;

import components.Window;
import controllers.StudentController;
import models.Student;
import screens.LoginScreen;
import util.AppContext;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private final JPasswordField oldPasswordField = new JPasswordField();
    private final JPasswordField newPasswordField = new JPasswordField();
    private final JPasswordField confirmPasswordField = new JPasswordField();
    private final StudentController controller = new StudentController();
    private final Window window;

    public SettingsPanel(Window window) {
        this.window = window;

        Student student = AppContext.getInstance().getLoggedInStudent();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        settingsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(settingsLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 35)));

        // Student's Name
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        JLabel nameLabel = new JLabel(student.getFirstName() + " " + student.getLastName());
        namePanel.add(nameLabel);
        panel.add(namePanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Student's Email
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        JLabel emailLabel = new JLabel(student.getEmail());
        emailPanel.add(emailLabel);
        panel.add(emailPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 35)));

        // Change Password Section
        JPanel changePasswordPanel = new JPanel();
        changePasswordPanel.setLayout(new BoxLayout(changePasswordPanel, BoxLayout.Y_AXIS));

        JLabel changePasswordLabel = new JLabel("Change Password");
        changePasswordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        changePasswordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePasswordPanel.add(changePasswordLabel);

        changePasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel oldPasswordPanel = new JPanel();
        oldPasswordPanel.setLayout(new BoxLayout(oldPasswordPanel, BoxLayout.X_AXIS));
        oldPasswordPanel.add(new JLabel("Old Password: "));
        oldPasswordPanel.add(Box.createRigidArea(new Dimension(42, 0)));
        oldPasswordField.setMaximumSize(new Dimension(200, 25));
        oldPasswordField.setMinimumSize(new Dimension(200, 25));
        oldPasswordField.setPreferredSize(new Dimension(200, 25));
        oldPasswordPanel.add(oldPasswordField);
        changePasswordPanel.add(oldPasswordPanel);

        changePasswordPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel newPasswordPanel = new JPanel();
        newPasswordPanel.setLayout(new BoxLayout(newPasswordPanel, BoxLayout.X_AXIS));
        newPasswordPanel.add(new JLabel("New Password: "));
        newPasswordPanel.add(Box.createRigidArea(new Dimension(35, 0)));
        newPasswordField.setMaximumSize(new Dimension(200, 25));
        newPasswordField.setMinimumSize(new Dimension(200, 25));
        newPasswordField.setPreferredSize(new Dimension(200, 25));
        newPasswordPanel.add(newPasswordField);
        changePasswordPanel.add(newPasswordPanel);

        changePasswordPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel confirmPasswordPanel = new JPanel();
        confirmPasswordPanel.setLayout(new BoxLayout(confirmPasswordPanel, BoxLayout.X_AXIS));
        confirmPasswordPanel.add(new JLabel("Confirm Password: "));
        confirmPasswordPanel.add(Box.createRigidArea(new Dimension(15, 0)));
        confirmPasswordField.setMaximumSize(new Dimension(200, 25));
        confirmPasswordField.setMinimumSize(new Dimension(200, 25));
        confirmPasswordField.setPreferredSize(new Dimension(200, 25));
        confirmPasswordPanel.add(confirmPasswordField);
        changePasswordPanel.add(confirmPasswordPanel);

        changePasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add ActionListener for button click here
        changePasswordButton.addActionListener(event -> changePassword());
        changePasswordPanel.add(changePasswordButton);

        panel.add(changePasswordPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 45)));

        JPanel logOutPanel = new JPanel();
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(event -> logOut());
        logOutPanel.add(logOutButton);

        panel.add(logOutPanel);

        panel.add(Box.createVerticalGlue()); // Pushes everything up, adds space at the bottom

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void changePassword() {
        String oldPassword = new String(oldPasswordField.getPassword());
        String newPassword = new String(newPasswordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        String changePasswordError = controller.changePassword(oldPassword, newPassword, confirmPassword);

        if (changePasswordError.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "You have successfully changed your password.",
                    "Password Changed",
                    JOptionPane.INFORMATION_MESSAGE
            );
            oldPasswordField.setText("");
            newPasswordField.setText("");
            confirmPasswordField.setText("");
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    changePasswordError,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void logOut() {
        int logOut = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to log out?",
                "Log Out",
                JOptionPane.YES_NO_OPTION
        );

        if (logOut == JOptionPane.YES_OPTION) {
            controller.logOut();
            window.showScreen(new LoginScreen(window));
        }
    }
}

