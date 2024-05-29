package components;

import javax.swing.*;
import java.awt.*;

public class CustomTextAreaPanel extends JPanel {
    public CustomTextAreaPanel(int width, int height) {
        JTextArea textArea = new JTextArea();
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        Dimension textAreaSize = new Dimension(width, height);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setTabSize(2);

        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaScrollPane.setPreferredSize(textAreaSize); // Set the same preferred size for the scroll pane
        textAreaScrollPane.setMaximumSize(textAreaSize);   // Set the same maximum size for the scroll pane
        textAreaScrollPane.setMinimumSize(textAreaSize);   // Set the same minimum size for the scroll pane
        textAreaScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);   // Align to the left
        textAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        this.add(textAreaScrollPane);

        this.setVisible(true);
    }
}
