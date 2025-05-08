package swing;

import javax.swing.*;
import java.awt.*;

public class CharacterScrollPanel extends JPanel {

    public CharacterScrollPanel() {
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 4, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.decode("#BBAEA5"));


        
        String[][] characters = {
            {"Ragdoll", "Ragdoll.jpg"},
            {"BSH Cinnamon", "BSH Cinnamon.jpg"},
            {"Munchkin", "Munchkin.jpg"},
            {"American Curl", "American Curl.jpg"},
            {"Anggora", "Anggora.jpg"},
            {"Bengal", "Bengal.jpg"},
            {"Calico", "Calico.jpg"},
            {"Maine Coon", "Maine Coon.jpg"},
            {"Scottish Fold", "Scottish Fold.jpg"},
            {"Siamese", "Siamese.jpg"},
            {"Sphynx", "Sphynx.jpg"},
            {"Abyssinian", "Abyssinian.jpg"},
            {"Oriental Shorthair", "Oriental Shorthair.jpg"},
            {"Savannah", "Savannah.jpg"},
            {"Himalayah", "Himalayah.jpg"}
        };

        for (String[] character : characters) {
            contentPanel.add(new CharacterCard(character[0], character[1]));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}
