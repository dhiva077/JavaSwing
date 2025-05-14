package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MeowSignalsPanel extends JPanel {
    public MeowSignalsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#DBD4CE"));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY),
                BorderFactory.createEmptyBorder(20, 30, 20, 30)
        ));

       
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(Color.decode("#DBD4CE"));
       

        add(titlePanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 15, 15));
        gridPanel.setBackground(Color.decode("#DBD4CE"));

        gridPanel.add(new MeowSignalsCard("Ekor Tegak Lurus",
                "https://i.pinimg.com/originals/29/e4/66/29e46616dd171a3e73b4bc8cb4ccc4e6.gif",
                "Menandakan rasa percaya diri dan suasana hati yang positif."));

        gridPanel.add(new MeowSignalsCard("Ekor Mengepal",
                "https://i.pinimg.com/originals/0a/4c/01/0a4c012cc7d2124853dd9ee86c535ca2.gif",
                "Tanda kewaspadaan atau kegelisahan."));

        gridPanel.add(new MeowSignalsCard("Ekor Mengembung",
                "https://i.pinimg.com/originals/c8/d1/b9/c8d1b976b5e1bc7c38375984fea488f0.gif",
                "Menunjukkan rasa takut atau merasa terancam."));

        gridPanel.add(new MeowSignalsCard("Telinga Rata ke Samping",
                "https://i.pinimg.com/originals/f5/74/28/f574281bfc9140030e3cd3e4c6afb8e7.gif",
                "Kucing sedang tenang dan santai."));

        gridPanel.add(new MeowSignalsCard("Telinga Maju & Mengecil",
                "https://i.pinimg.com/originals/c9/67/12/c96712501891d0eb0a5911fa1b1ec403.gif",
                "Menunjukkan ketakutan atau rasa terancam."));

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ---------------------------
    class MeowSignalsCard extends JPanel {
        private final String title;
        private final String imageUrl;
        private final String description;

        public MeowSignalsCard(String title, String imageUrl, String description) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.description = description;

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 1),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JLabel titleLabel = new JLabel("<html><center>" + title + "</center></html>");
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
            titleLabel.setAlignmentX(CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(10));

            // Load GIF
            JLabel imageLabel = new JLabel();
            try {
                URL url = new URL(imageUrl);
                ImageIcon icon = new ImageIcon(url);
                Image scaled = icon.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
                imageLabel.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                imageLabel.setText("Image failed");
            }
            imageLabel.setAlignmentX(CENTER_ALIGNMENT);
            add(imageLabel);
            add(Box.createVerticalStrut(10));

            JLabel descPreview = new JLabel("<html><div style='text-align:center; width:150px;'>" + (description.length() > 50 ? description.substring(0, 50) + "..." : description) + "</div></html>");
            descPreview.setFont(new Font("SansSerif", Font.PLAIN, 12));
            descPreview.setAlignmentX(CENTER_ALIGNMENT);
            add(descPreview);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showDetailPopup();
                }
            });
        }

        private void showDetailPopup() {
            JDialog dialog = new JDialog((Frame) null, title, true);
            dialog.setLayout(new BorderLayout(10, 10));
            dialog.setSize(400, 450);
            dialog.setLocationRelativeTo(null);

            JLabel imgLabel = new JLabel();
            try {
                URL url = new URL(imageUrl);
                ImageIcon icon = new ImageIcon(url);
                Image scaled = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                imgLabel.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                imgLabel.setText("Gagal memuat gambar.");
            }
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dialog.add(imgLabel, BorderLayout.NORTH);

            JTextArea descArea = new JTextArea(description);
            descArea.setLineWrap(true);
            descArea.setWrapStyleWord(true);
            descArea.setEditable(false);
            descArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
            descArea.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

            dialog.add(new JScrollPane(descArea), BorderLayout.CENTER);

            JButton closeBtn = new JButton("Tutup");
            closeBtn.addActionListener(e -> dialog.dispose());
            JPanel bottomPanel = new JPanel();
            bottomPanel.add(closeBtn);

            dialog.add(bottomPanel, BorderLayout.SOUTH);
            dialog.setVisible(true);
        }
    }
}
