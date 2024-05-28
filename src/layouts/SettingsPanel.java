package layouts;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(settingsLabel);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        // Change Password Setting
        JPanel changePasswordPanel = new JPanel();
        changePasswordPanel.setLayout(new BoxLayout(changePasswordPanel, BoxLayout.X_AXIS));
        changePasswordPanel.add(new JLabel("Change Password: "));
        changePasswordPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton changePasswordButton = new JButton("Change");
        changePasswordPanel.add(changePasswordButton);
        this.add(changePasswordPanel);

        this.add(Box.createRigidArea(new Dimension(0, 10)));

        // Notification Preferences Setting
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.X_AXIS));
        notificationPanel.add(new JLabel("Email Notifications: "));
        JCheckBox emailNotificationsCheckBox = new JCheckBox();
        notificationPanel.add(emailNotificationsCheckBox);
        this.add(notificationPanel);

        // Add more settings as needed
        this.add(Box.createVerticalGlue()); // Pushes everything up, adds space at the bottom

        this.setVisible(true);
    }
}
