package swing;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

public class CelebrityPanel extends JPanel {
    public CelebrityPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));
        setBackground(Color.decode("#DBD4CE"));

        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        gridPanel.setBackground(Color.decode("#DBD4CE"));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        List<CelebrityItem> cats = Arrays.asList(
            new CelebrityItem("Maine Coon", "Maine Coon.jpg", "Maine Coon adalah kucing besar yang ramah, lembut, dan suka bermain."),
            new CelebrityItem("Sphynx", "Sphynx.jpg", "Sphynx tidak memiliki bulu, sangat hangat, dan suka berinteraksi dengan manusia."),
            new CelebrityItem("Scottish Fold", "Scottish Fold.jpg", "Ciri khasnya adalah telinga melipat ke depan, membuat wajahnya terlihat bulat dan lucu."),
            new CelebrityItem("Bengal", "Bengal.jpg", "Memiliki pola eksotis seperti macan tutul, sangat energik dan aktif."),
            new CelebrityItem("Ragdoll", "Ragdoll.jpg", "Ragdoll tenang, manja, dan sering relaks seperti boneka saat digendong.")
        );

        for (CelebrityItem cat : cats) {
            gridPanel.add(new CelebrityCard(cat));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    // Inner class sebagai data model
    static class CelebrityItem {
        String name, image, description;

        CelebrityItem(String name, String image, String description) {
            this.name = name;
            this.image = image;
            this.description = description;
        }
    }

    // Inner class kartu tampilan
    static class CelebrityCard extends JPanel {
        public CelebrityCard(CelebrityItem data) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.decode("#DBD4CE"));
            setPreferredSize(new Dimension(250, 300));
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            JLabel imageLabel;
            ImageIcon icon = null;

            try {
                InputStream imgStream = getClass().getClassLoader().getResourceAsStream(data.image);
                if (imgStream != null) {
                    Image img = ImageIO.read(imgStream).getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                    imageLabel = new JLabel(icon);
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

            imageLabel.setAlignmentX(CENTER_ALIGNMENT);
            imageLabel.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 200)));

            JLabel nameLabel = new JLabel(data.name, SwingConstants.CENTER);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
            nameLabel.setAlignmentX(CENTER_ALIGNMENT);
            nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

            add(imageLabel);
            add(nameLabel);

            ImageIcon finalIcon = icon;
            this.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JTextArea textArea = new JTextArea(data.description);
                    textArea.setWrapStyleWord(true);
                    textArea.setLineWrap(true);
                    textArea.setEditable(false);
                    textArea.setFocusable(false);
                    textArea.setOpaque(false);
                    textArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
                    textArea.setMargin(new Insets(10, 10, 10, 10));

                    JPanel messagePanel = new JPanel(new BorderLayout());
                    messagePanel.add(textArea, BorderLayout.CENTER);
                    messagePanel.setPreferredSize(new Dimension(350, 150));

                    JOptionPane.showMessageDialog(
                        null,
                        messagePanel,
                        data.name,
                        JOptionPane.INFORMATION_MESSAGE,
                        finalIcon != null ? finalIcon : UIManager.getIcon("OptionPane.informationIcon")
                    );
                }
            });
        }
    }
}
