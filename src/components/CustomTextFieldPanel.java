package components;

import javax.swing.*;
import java.awt.*;

public class CustomTextFieldPanel extends JPanel {
    public CustomTextFieldPanel(int width, int height) {
        JTextField textField = new JTextField();
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        Dimension textFieldSize = new Dimension(width, height);

        JScrollPane textFieldScrollPane = new JScrollPane(textField);
        textFieldScrollPane.setPreferredSize(textFieldSize); // Set the same preferred size for the scroll pane
        textFieldScrollPane.setMaximumSize(textFieldSize);   // Set the same maximum size for the scroll pane
        textFieldScrollPane.setMinimumSize(textFieldSize);   // Set the same minimum size for the scroll pane
        textFieldScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);   // Align to the left
        textFieldScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        this.add(textFieldScrollPane);

        this.setVisible(true);
    }
}
