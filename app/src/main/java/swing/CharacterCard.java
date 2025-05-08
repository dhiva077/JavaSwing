package swing;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

public class CharacterCard extends JPanel {
    public CharacterCard(String characterName, String imageName) {
        setBackground(Color.decode("#DBD4CE"));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setPreferredSize(new Dimension(200, 250));

        // Load image from resources folder
        JLabel imageLabel;
        ImageIcon icon = null;
        try {
            // Construct the path to the image within the resources directory.
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);


            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
                imageLabel = new JLabel(icon);
            } else {
                String imagePath = null;
                System.err.println("Image not found: " + imagePath + " for " + characterName);
                imageLabel = new JLabel("No Image", SwingConstants.CENTER);
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.LIGHT_GRAY);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + imageName + " for " + characterName + ": " + e.getMessage());
            imageLabel = new JLabel("Error", SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.RED);
        }

        imageLabel.setPreferredSize(new Dimension(180, 180));
        imageLabel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 220)));

        JLabel nameLabel = new JLabel(characterName, SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Add a JPanel for nameLabel
        namePanel.setBackground(Color.decode("#DBD4CE")); // Ensure the background is white
        namePanel.add(nameLabel);

        add(imageLabel, BorderLayout.CENTER);
        add(namePanel, BorderLayout.SOUTH); // Use the JPanel instead of adding nameLabel directly;
    }
}
