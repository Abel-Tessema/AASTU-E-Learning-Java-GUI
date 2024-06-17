package layouts;

import components.*;
import controllers.CourseController;
import models.Course;

import javax.swing.*;
import java.awt.*;

public class CoursesPanel extends JPanel {
    private final JPanel mainContentPanel;
    private final CardLayout cardLayout;
    private final CourseController controller = new CourseController();
    private final JPanel courseCardsPanel;

    public CoursesPanel(JPanel mainContentPanel, CardLayout cardLayout) {
        this.mainContentPanel = mainContentPanel;
        this.cardLayout = cardLayout;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel coursesLabel = new JLabel("Courses");
        coursesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        coursesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(coursesLabel);

        courseCardsPanel = new JPanel();
        courseCardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        courseCardsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addCourseCards();

        panel.add(courseCardsPanel);

//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void addCourseCards() {
        String fetchCoursesError = controller.fetchAllCourses();

        if (fetchCoursesError.isEmpty() && !controller.getCourses().isEmpty()) {
            courseCardsPanel.removeAll();
            for (Course course : controller.getCourses()) {
                CourseCard courseCard = new CourseCard(course, mainContentPanel, cardLayout);
                courseCardsPanel.add(courseCard);
            }
        } else if (fetchCoursesError.isEmpty()) {
            courseCardsPanel.removeAll();
            courseCardsPanel.add(new JLabel("No courses available."));
        } else {
            courseCardsPanel.removeAll();
            JButton refreshButton = new JButton("Refresh");
            refreshButton.addActionListener(event -> addCourseCards());
            courseCardsPanel.add(new JLabel(fetchCoursesError));
            courseCardsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            courseCardsPanel.add(refreshButton);
        }
    }
}
