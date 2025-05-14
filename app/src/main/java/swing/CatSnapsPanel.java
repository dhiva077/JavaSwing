package swing;

import javax.swing.*;
import java.awt.*;

public class CatSnapsPanel extends JPanel {
    public CatSnapsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 3, 15, 15)); // 3 kolom, baris otomatis
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Tambahkan kartu-kartu CatSnapCard
        contentPanel.add(new CatSnapCard("Kucing Tidur", "images/sleeping.jpg", "Kucing sedang tidur nyenyak."));
        contentPanel.add(new CatSnapCard("Kucing Bermain", "images/play.jpg", "Kucing bermain dengan benang."));
        contentPanel.add(new CatSnapCard("Kucing Melompat", "images/jump.jpg", "Kucing sedang melompat tinggi."));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }
}
