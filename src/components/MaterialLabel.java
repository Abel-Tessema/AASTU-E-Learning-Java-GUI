package components;

import models.Material;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MaterialLabel extends JLabel {
    private final Material material;

    public MaterialLabel(Material material) {
        super(material.getName());
        this.material = material;

        this.addMouseListener(new MouseAdapter() {
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

    private void saveFile(String sourcePath, String destinationPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            while (fis.read(buffer) > 0) {
                fos.write(buffer);
            }
            JOptionPane.showMessageDialog(this, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
