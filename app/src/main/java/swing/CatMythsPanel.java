package swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CatMythsPanel extends JPanel {
    public CatMythsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#DBD4CE"));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));

        // Panel kontainer untuk cards
        JPanel cardPanel = new JPanel(new GridLayout(0, 2, 14, 14));
        cardPanel.setBackground(Color.decode("#DBD4CE"));

        // List mitos
        ArrayList<CatMythCard> mythCards = new ArrayList<>();
        mythCards.add(new CatMythCard(
            "Kucing Hitam Membawa Sial",
            "Mitos ini populer di Eropa dan Amerika, padahal di Jepang dan Inggris, kucing hitam justru dianggap membawa keberuntungan!",
            "app/src/main/resources/hitam.jpg"
        ));
        mythCards.add(new CatMythCard(
            "Kucing Punya 9 Nyawa",
            "Mereka memang lincah dan refleksnya cepat, tapi secara biologis, kucing tetap hanya punya satu nyawa dan butuh perhatian kesehatan.",
            "/assets/nine_lives.png"
        ));
        mythCards.add(new CatMythCard(
            "Kucing Mengambil Nafas Bayi",
            "Mereka hanya tertarik dengan tempat hangat, bukan 'mengambil napas'. Tetap awasi interaksi dengan bayi untuk keamanan.",
            "/assets/baby_cat.png"
        ));
        mythCards.add(new CatMythCard(
            "Air Liur Kucing Menyembuhkan Luka",
            "Faktanya, air liur kucing mengandung banyak bakteri. Justru bisa memperparah luka, bukan menyembuhkan.",
            "/assets/saliva_warning.png"
        ));
        mythCards.add(new CatMythCard(
            "Susu Baik untuk Kucing Dewasa",
            "Kebanyakan kucing dewasa intoleran laktosa. Memberi susu bisa menyebabkan diare. Lebih baik beri air putih bersih.",
            "/assets/milk_warning.png"
        ));

        // Tambahkan ke panel
        for (CatMythCard card : mythCards) {
            cardPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }
}
