package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

class CatSnapCard extends JPanel {
    private final String imagePath;
    private final String description;

    public CatSnapCard(String title, String imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Gambar
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imagePath);
            if (imgStream != null) {
                ImageIcon icon = new ImageIcon(ImageIO.read(imgStream));

                // Ukuran tetap lebar, tinggi menyesuaikan rasio
                int displayWidth = 200;
                int originalWidth = icon.getIconWidth();
                int originalHeight = icon.getIconHeight();
                int displayHeight = (originalHeight * displayWidth) / originalWidth;

                Image scaledImage = icon.getImage().getScaledInstance(displayWidth, displayHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setText("Gambar Tidak Ditemukan");
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.LIGHT_GRAY);
            }
        } catch (IOException e) {
            imageLabel.setText("Gagal Memuat Gambar");
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.RED);
        }

        add(imageLabel, BorderLayout.CENTER);

        // Klik kartu menampilkan pop-up
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showDetailPopup();
            }
        });
    }

    private void showDetailPopup() {
        JDialog dialog = new JDialog((Frame) null, "Detail", true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(null);

        // Gambar di atas
        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imagePath);
            if (imgStream != null) {
                ImageIcon icon = new ImageIcon(ImageIO.read(imgStream));

                // Rasio sesuai aslinya
                int displayWidth = 300;
                int displayHeight = (icon.getIconHeight() * displayWidth) / icon.getIconWidth();
                Image image = icon.getImage().getScaledInstance(displayWidth, displayHeight, Image.SCALE_SMOOTH);

                imgLabel.setIcon(new ImageIcon(image));
            } else {
                imgLabel.setText("Gambar Tidak Ditemukan");
                imgLabel.setOpaque(true);
                imgLabel.setBackground(Color.LIGHT_GRAY);
            }
        } catch (IOException e) {
            imgLabel.setText("Gagal Memuat Gambar");
            imgLabel.setOpaque(true);
            imgLabel.setBackground(Color.RED);
        }

        dialog.add(imgLabel, BorderLayout.NORTH);

        // Deskripsi
        JTextArea descArea = new JTextArea(description);
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descArea.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        dialog.add(new JScrollPane(descArea), BorderLayout.CENTER);

        // Tombol tutup
        JButton closeBtn = new JButton("Tutup");
        closeBtn.addActionListener(e -> dialog.dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.add(closeBtn);
        dialog.add(btnPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
