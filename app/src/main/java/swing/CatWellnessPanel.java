package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class CatWellnessPanel extends JPanel {

    public CatWellnessPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));

        JPanel contentPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        contentPanel.setBackground(Color.decode("#DBD4CE"));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        List<CatWellnessItem> items = Arrays.asList(
            new CatWellnessItem("Vaksinasi & Vitamin", "vaksin.jpg", "Jadwalkan vaksinasi rutin mulai dari usia 6 minggu..."),
            new CatWellnessItem("Nutrisi Sesuai Usia", "nutrisi.jpg", "Pilih makanan khusus kitten..."),
            new CatWellnessItem("Grooming & Kuku", "grooming.jpg", "Mandikan kucing setiap 2–4 minggu..."),
            new CatWellnessItem("Tanda Sakit", "lemas.jpg", "Jika kucing lemas, nafsu makan turun..."),
            new CatWellnessItem("Pencegahan Kutu & Cacing", "pencegahan.jpg", "Gunakan obat kutu dan cacing secara rutin..."),
            new CatWellnessItem("Kesehatan Mental", "kesehatan.jpg", "Sediakan mainan dan tempat persembunyian..."),
            new CatWellnessItem("Sterilisasi", "steril.jpg", "Sterilisasi dapat mencegah penyakit..."),
            new CatWellnessItem("Pemeriksaan Rutin", "pemeriksaan.jpg", "Bawa kucing untuk cek kesehatan...")
        );

        for (CatWellnessItem item : items) {
            contentPanel.add(new CatWellnessCard(item));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    // ===== ITEM DATA CLASS =====
    static class CatWellnessItem {
        String title, imageName, description;

        public CatWellnessItem(String title, String imageName, String description) {
            this.title = title;
            this.imageName = imageName;
            this.description = description;
        }
    }

    // ===== CARD PANEL =====
    static class CatWellnessCard extends JPanel {
        public CatWellnessCard(CatWellnessItem item) {
            setBackground(Color.decode("#DBD4CE"));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            setPreferredSize(new Dimension(150, 180));

            // ===== Title =====
            JLabel titleLabel = new JLabel(item.title, SwingConstants.CENTER);
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // ===== Image =====
            JLabel imageLabel;
            try {
                InputStream imgStream = getClass().getClassLoader().getResourceAsStream(item.imageName);
                if (imgStream != null) {
                    Image img = ImageIO.read(imgStream).getScaledInstance(160, 120, Image.SCALE_SMOOTH);
                    imageLabel = new JLabel(new ImageIcon(img));
                } else {
                    imageLabel = new JLabel("No Image", SwingConstants.CENTER);
                    imageLabel.setOpaque(true);
                    imageLabel.setBackground(Color.LIGHT_GRAY);
                }
            } catch (IOException e) {
                imageLabel = new JLabel("Error", SwingConstants.CENTER);
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.RED);
            }
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // ===== Description (hidden by default) =====
            JTextArea descArea = new JTextArea(item.description);
            descArea.setWrapStyleWord(true);
            descArea.setLineWrap(true);
            descArea.setEditable(false);
            descArea.setVisible(false); // awalnya disembunyikan
            descArea.setOpaque(false);
            descArea.setFont(new Font("SansSerif", Font.PLAIN, 12));
            descArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            descArea.setAlignmentX(Component.CENTER_ALIGNMENT);

            // ===== Click listener to show popup with image and description =====
this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
this.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Panel utama isi popup
        JPanel popupPanel = new JPanel();
        popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.Y_AXIS));
        popupPanel.setBackground(Color.WHITE);
        popupPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Gambar
        JLabel imagePopupLabel;
        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(item.imageName);
            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(240, 180, Image.SCALE_SMOOTH);
                imagePopupLabel = new JLabel(new ImageIcon(img));
            } else {
                imagePopupLabel = new JLabel("No Image", SwingConstants.CENTER);
                imagePopupLabel.setOpaque(true);
                imagePopupLabel.setBackground(Color.LIGHT_GRAY);
                imagePopupLabel.setPreferredSize(new Dimension(240, 180));
            }
        } catch (IOException ex) {
            imagePopupLabel = new JLabel("Error Loading Image", SwingConstants.CENTER);
            imagePopupLabel.setOpaque(true);
            imagePopupLabel.setBackground(Color.RED);
            imagePopupLabel.setPreferredSize(new Dimension(240, 180));
        }
        imagePopupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Deskripsi
        JTextArea textArea = new JTextArea(item.description);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(280, 120));
        scrollPane.setBorder(null);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tambahkan ke panel popup
        popupPanel.add(imagePopupLabel);
        popupPanel.add(Box.createVerticalStrut(10));
        popupPanel.add(scrollPane);

        // Tampilkan popup
        JOptionPane.showMessageDialog(
            SwingUtilities.getWindowAncestor(CatWellnessCard.this),
            popupPanel,
            item.title,
            JOptionPane.INFORMATION_MESSAGE
        );
    }
});

            add(titleLabel);
            add(Box.createVerticalStrut(8));
            add(imageLabel);
            add(Box.createVerticalStrut(8));
            add(descArea);
        }
    }
}
