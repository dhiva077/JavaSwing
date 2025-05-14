package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class FunnyPoseCard extends JPanel {
    private FunnyPoseItem item;
    private JLabel imageLabel;

    // Inner class item
    public static class FunnyPoseItem {
        public String title;
        public String imageUrl;
        public boolean isGif;
        public String description;

        public FunnyPoseItem(String title, String imageUrl, boolean isGif, String description) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.isGif = isGif;
            this.description = description;
        }
    }

    public FunnyPoseCard(FunnyPoseItem item) {
        this.item = item;

        setBackground(Color.decode("#DBD4CE"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel titleLabel = new JLabel(item.title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Load image
        imageLabel = new JLabel();
imageLabel.setAlignmentX(CENTER_ALIGNMENT);
imageLabel.setPreferredSize(new Dimension(150, 180));
imageLabel.setMaximumSize(new Dimension(150, 180));
imageLabel.setMinimumSize(new Dimension(150, 180));
imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(titleLabel);
        add(Box.createVerticalStrut(10));
        add(imageLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopup();
            }
        });
    }

    private void showPopup() {
        JDialog dialog = new JDialog((Frame) null, item.title, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(null);

        // Image
        JLabel imgLabel = new JLabel();
        loadImageToLabel(item.imageUrl, item.isGif, imgLabel);
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Description
        JTextArea descArea = new JTextArea(item.description);
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descArea.setOpaque(false);
        descArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dialog.add(imgLabel, BorderLayout.CENTER);
        dialog.add(descArea, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void loadImageToLabel(String urlStr, boolean isGif, JLabel label) {
        try {
            URL url = new URL(urlStr);
            ImageIcon icon = new ImageIcon(url);
    
            if (!isGif) {
                // Gambar biasa → di-scale
                Image scaled = icon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
            } else {
                // GIF → tetap animasi, tapi dipaksa muat ke ukuran label
                icon.setImage(icon.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT));
            }
    
            imageLabel.setIcon(icon);
        } catch (Exception e) {
            imageLabel.setText("Image Error");
            imageLabel.setForeground(Color.RED);
        }
    }
}
