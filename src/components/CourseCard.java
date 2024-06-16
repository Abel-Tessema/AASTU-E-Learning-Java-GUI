package components;

import layouts.CourseDetailsPanel;
import models.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseCard extends JPanel {
    private final Course course;
    private final JPanel mainContentPanel;
    private final CardLayout cardLayout;

    public CourseCard(Course course, JPanel mainContentPanel, CardLayout cardLayout) {
        this.course = course;
        this.mainContentPanel = mainContentPanel;
        this.cardLayout = cardLayout;

        Image courseImage = new ImageIcon(course.getImagePath()).getImage();
        Image scaledImage = courseImage.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel courseImageLabel = new JLabel(scaledIcon);
        courseImageLabel.setPreferredSize(new Dimension(180, 150));
        courseImageLabel.setMaximumSize(new Dimension(180, 150));
        courseImageLabel.setMinimumSize(new Dimension(180, 150));
        courseImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel courseNameLabel = new JLabel(course.getName());
        courseNameLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        courseNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel courseCodeLabel = new JLabel(course.getCode());
        courseCodeLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        courseCodeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(180, 200));
        this.setMinimumSize(new Dimension(180, 200));
        this.setMaximumSize(new Dimension(180, 200));

        this.add(courseImageLabel);
        this.add(Box.createVerticalGlue());
        this.add(courseNameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 2)));
        this.add(courseCodeLabel);
        this.add(Box.createVerticalGlue());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showCourseDetailsPanel();
            }
        });
        this.setVisible(true);
    }

    private void showCourseDetailsPanel() {
        CourseDetailsPanel courseDetailsPanel = new CourseDetailsPanel(course, mainContentPanel, cardLayout);
        mainContentPanel.add(courseDetailsPanel, "CourseDetailsPanel");
        cardLayout.show(mainContentPanel, "CourseDetailsPanel");
    }
}
