package layouts;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(settingsLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Change Password Setting
        JPanel changePasswordPanel = new JPanel();
        changePasswordPanel.setLayout(new BoxLayout(changePasswordPanel, BoxLayout.X_AXIS));
        changePasswordPanel.add(new JLabel("Change Password: "));
        changePasswordPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton changePasswordButton = new JButton("Change");
        changePasswordPanel.add(changePasswordButton);
        panel.add(changePasswordPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Notification Preferences Setting
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.X_AXIS));
        notificationPanel.add(new JLabel("Email Notifications: "));
        JCheckBox emailNotificationsCheckBox = new JCheckBox();
        notificationPanel.add(emailNotificationsCheckBox);
        panel.add(notificationPanel);

        // Add more settings as needed
        panel.add(Box.createVerticalGlue()); // Pushes everything up, adds space at the bottom

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
