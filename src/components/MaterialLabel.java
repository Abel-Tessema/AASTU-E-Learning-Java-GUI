package components;

import models.Material;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MaterialLabel extends JLabel {
    private final Material material;
    private boolean isHovered = false;

    public MaterialLabel(Material material) {
        super(material.getName());
        this.material = material;

        this.setHorizontalAlignment(SwingConstants.CENTER); // Ensure the label is centered

        // Set the preferred size to avoid vertical expansion
        setPreferredSize(new Dimension(200, 30));
        setMaximumSize(new Dimension(200, 30));
        setMinimumSize(new Dimension(200, 30));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save File");
                // Extract the file name from the full file path
                File sourceFile = new File(material.getFilePath());
                String fileName = sourceFile.getName();

                // Set the default file name in the file chooser
                fileChooser.setSelectedFile(new File(fileName));

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    saveFile(material.getFilePath(), fileToSave.getAbsolutePath());
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isHovered) {
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(getText());
            int textHeight = fm.getAscent();
            int startX = (getWidth() - textWidth) / 2;
            int startY = textHeight + 10; // Slightly below the text
            g.drawLine(startX, startY, startX + textWidth, startY);
        }
    }

    private void saveFile(String sourcePath, String destinationPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, bytesRead);
            }
            JOptionPane.showMessageDialog(this, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
