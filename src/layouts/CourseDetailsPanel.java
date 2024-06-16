package layouts;

import components.MaterialLabel;
import controllers.MaterialController;
import models.Course;
import models.Material;

import javax.swing.*;
import java.awt.*;

public class CourseDetailsPanel extends JPanel {
    private final MaterialController controller = new MaterialController();
    private final Course course;
    private final JPanel mainContentPanel;
    private final CardLayout cardLayout;
    private final JPanel materialsPanel;

    public CourseDetailsPanel(Course course, JPanel mainContentPanel, CardLayout cardLayout) {
        this.course = course;
        this.mainContentPanel = mainContentPanel;
        this.cardLayout = cardLayout;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel imageAndDescriptionPanel = new JPanel();
        imageAndDescriptionPanel.setLayout(new BoxLayout(imageAndDescriptionPanel, BoxLayout.X_AXIS));

        Image courseImage = new ImageIcon(course.getImagePath()).getImage();
        Image scaledImage = courseImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel courseImageLabel = new JLabel(scaledIcon);
        courseImageLabel.setPreferredSize(new Dimension(180, 180));
        courseImageLabel.setMaximumSize(new Dimension(180, 180));
        courseImageLabel.setMinimumSize(new Dimension(180, 180));
        courseImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        imageAndDescriptionPanel.add(courseImageLabel);
        imageAndDescriptionPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JPanel nameAndDescriptionPanel = new JPanel();
        nameAndDescriptionPanel.setLayout(new BoxLayout(nameAndDescriptionPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(
                "<html><body style='width: 300px'>" +
                        course.getName() +
                        " (" + course.getCode() + ")" +
                        "</body></html>"
        );
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nameAndDescriptionPanel.add(nameLabel);
        nameAndDescriptionPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel descriptionLabel = new JLabel(
                "<html><body style='width: 300px; text-align: justify'>" +
                        course.getDescription() +
                        "</body></html>"
        );
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 13));
//        descriptionLabel.setMaximumSize(new Dimension(300, 500));
//        descriptionLabel.setPreferredSize(new Dimension(300, 500));

        nameAndDescriptionPanel.add(descriptionLabel);

        imageAndDescriptionPanel.add(nameAndDescriptionPanel);

        panel.add(imageAndDescriptionPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        materialsPanel = new JPanel();
        materialsPanel.setLayout(new BoxLayout(materialsPanel, BoxLayout.Y_AXIS));

        addMaterials();

        panel.add(materialsPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainContentPanel, "CoursesPanel"));
        panel.add(backButton);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void addMaterials() {
        String fetchMaterialsError = controller.fetchAllMaterials(course.getId());

        if (fetchMaterialsError.isEmpty()) {
            materialsPanel.removeAll();
            for (Material material : controller.getMaterials()) {
                materialsPanel.add(new MaterialLabel(material));
            }
        } else {
            materialsPanel.removeAll();
            JButton refreshButton = new JButton("Refresh");
            refreshButton.addActionListener(event -> addMaterials());
            materialsPanel.add(new JLabel(fetchMaterialsError));
            materialsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            materialsPanel.add(refreshButton);
        }
    }
}
