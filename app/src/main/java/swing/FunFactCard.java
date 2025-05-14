package swing;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

public class FunFactCard extends JPanel {
    public FunFactCard(String factText, String imageName, String description) {
        setBackground(Color.decode("#DBD4CE"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setPreferredSize(new Dimension(200, 250));

        JLabel imageLabel;
        ImageIcon icon = null;

        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);
            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
                imageLabel = new JLabel(icon);
            } else {
                System.err.println("Image not found: " + imageName);
                imageLabel = new JLabel("No Image", SwingConstants.CENTER);
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.LIGHT_GRAY);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + imageName + ": " + e.getMessage());
            imageLabel = new JLabel("Error", SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.RED);
        }

        imageLabel.setPreferredSize(new Dimension(180, 180));
        imageLabel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 220)));
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(factText, SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
        namePanel.setBackground(Color.decode("#DBD4CE")); 
        namePanel.add(nameLabel);

        add(imageLabel, BorderLayout.CENTER);
        add(namePanel, BorderLayout.SOUTH); 

        // Event listener: tampilkan deskripsi dengan gambar
        ImageIcon finalIcon = icon; // supaya bisa digunakan di dalam lambda
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextArea textArea = new JTextArea(description);
                    textArea.setWrapStyleWord(true);
                    textArea.setLineWrap(true);
                    textArea.setEditable(false);
                    textArea.setFocusable(false);
                    textArea.setOpaque(false);
                    textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
                    textArea.setMargin(new Insets(10, 10, 10, 10)); // <-- kasih margin biar ga mepet

                    // Panel pembungkus supaya padding tetap terlihat bagus di JOptionPane
                    JPanel messagePanel = new JPanel(new BorderLayout());
                    messagePanel.add(textArea, BorderLayout.CENTER);
                    messagePanel.setPreferredSize(new Dimension(350, 150)); // <= batasi lebar maksimal

                    JOptionPane.showMessageDialog(
                        null,
                        messagePanel,
                        factText,
                        JOptionPane.INFORMATION_MESSAGE,
                        finalIcon != null ? finalIcon : UIManager.getIcon("OptionPane.informationIcon")
                    );

            }
        });
    }
}
