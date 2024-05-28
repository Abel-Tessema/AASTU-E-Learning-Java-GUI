package components;

import javax.swing.*;
import java.awt.*;

public class CourseCard extends JPanel {
    private final String courseName;

    public CourseCard(String courseName) {
        this.courseName = courseName;
        JLabel courseLabel = new JLabel(courseName);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(courseLabel);
    }
}
