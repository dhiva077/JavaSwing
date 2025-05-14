package swing;

import javax.swing.*;
import java.awt.*;

public class CharacterScrollPanel extends JPanel {

    public CharacterScrollPanel() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 4, 10, 10)); 
        contentPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        contentPanel.setBackground(Color.decode("#DBD4CE"));

        // Daftar karakter kucing dengan nama, gambar, dan deskripsi
        CharacterItem[] characters = {
            new CharacterItem("Ragdoll", "Ragdoll.jpg", "Ragdoll terkenal dengan sifatnya yang tenang dan suka dipeluk. Mereka biasanya sangat jinak dan ramah."),
            new CharacterItem("BSH Cinnamon", "BSH Cinnamon.jpg", "British Shorthair berwarna cinnamon ini memiliki bulu yang lebat dan kepribadian yang kalem."),
            new CharacterItem("Munchkin", "Munchkin.jpg", "Munchkin dikenal karena kakinya yang pendek, tapi tetap lincah dan aktif."),
            new CharacterItem("American Curl", "American Curl.jpg", "American Curl memiliki ciri khas telinga yang melengkung ke belakang. Sangat unik!"),
            new CharacterItem("Anggora", "Anggora.jpg", "Kucing Anggora memiliki bulu panjang dan kepribadian yang aktif serta suka bermain."),
            new CharacterItem("Bengal", "Bengal.jpg", "Bengal memiliki corak eksotis mirip macan tutul. Energik dan cerdas!"),
            new CharacterItem("Calico", "Calico.jpg", "Kucing calico punya kombinasi warna unik. Hampir semua calico adalah betina."),
            new CharacterItem("Maine Coon", "Maine Coon.jpg", "Salah satu ras terbesar, Maine Coon dikenal lembut, setia, dan suka bermain."),
            new CharacterItem("Scottish Fold", "Scottish Fold.jpg", "Memiliki telinga yang terlipat ke bawah, Scottish Fold sangat populer dan menggemaskan."),
            new CharacterItem("Siamese", "Siamese.jpg", "Siamese sangat vokal dan suka berinteraksi dengan manusia. Matanya biru terang memikat!"),
            new CharacterItem("Sphynx", "Sphynx.jpg", "Tanpa bulu tapi hangat dan penuh kasih. Sphynx adalah kucing yang sangat sosial."),
            new CharacterItem("Abyssinian", "Abyssinian.jpg", "Abyssinian sangat aktif dan cerdas. Bulu mereka memiliki efek 'ticked' yang khas."),
            new CharacterItem("Oriental Shorthair", "Oriental Shorthair.jpg", "Bentuk tubuh ramping dan telinga besar. Suka bersosialisasi."),
            new CharacterItem("Savannah", "Savannah.jpg", "Savannah adalah hasil persilangan dengan kucing liar. Lincah dan eksotis."),
            new CharacterItem("Himalayah", "Himalayah.jpg", "Perpaduan dari Persia dan Siamese. Cantik dengan mata biru dan bulu panjang.")
        };

        for (CharacterItem c : characters) {
            contentPanel.add(new CharacterCard(c.name, c.imageName, c.description));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    // Inner class untuk menyimpan data karakter
    static class CharacterItem {
        String name;
        String imageName;
        String description;

        public CharacterItem(String name, String imageName, String description) {
            this.name = name;
            this.imageName = imageName;
            this.description = description;
        }
    }
}
