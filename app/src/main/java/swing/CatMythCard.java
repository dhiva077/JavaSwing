package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatMythCard extends JPanel {
    private JTextArea descriptionArea;
    private boolean expanded = false;
    private final String title;
    private final String description;
    private final String imagePath; // Bisa berupa "/assets/..." atau URL

    public CatMythCard(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));

        // Label Judul
        JLabel titleLabel = new JLabel("🧠 " + title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLabel.setForeground(Color.DARK_GRAY);

        // Area Deskripsi
        descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setOpaque(false);
        descriptionArea.setVisible(false);

        // Mouse Listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expanded = !expanded;
                descriptionArea.setVisible(expanded);
                revalidate();
                repaint();

                showPopup();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(240, 240, 240));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#DBD4CE"));
                setCursor(Cursor.getDefaultCursor());
            }
        });

        // Layout
        add(titleLabel, BorderLayout.NORTH);
        add(descriptionArea, BorderLayout.CENTER);
    }

    private void showPopup() {
        ImageIcon icon = null;
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                icon = new ImageIcon(getClass().getResource(imagePath));
                Image scaled = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar: " + imagePath);
        }

        JOptionPane.showMessageDialog(
            this,
            description,
            title,
            JOptionPane.INFORMATION_MESSAGE,
            icon
        );
    }
}
