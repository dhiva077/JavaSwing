package swing;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class FunnyPosePanel extends JPanel {
    public FunnyPosePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        setBackground(Color.decode("#DBD4CE"));

        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        gridPanel.setBackground(Color.decode("#DBD4CE"));

        List<FunnyPoseCard.FunnyPoseItem> poses = Arrays.asList(
            new FunnyPoseCard.FunnyPoseItem("Gitaran", "https://media.tenor.com/RIxCFKqtj6cAAAAi/guitar-cat.gif", true, "Kucing bermain gitar, klasik!"),
            new FunnyPoseCard.FunnyPoseItem("Kucing Pose Heng", "https://media1.tenor.com/m/4o9U6pB9ivcAAAAC/heng-cats.gif", true, "Ekspresi penuh beban hidup."),
            new FunnyPoseCard.FunnyPoseItem("Kucing Nana", "https://media1.tenor.com/m/Qz_6zN94oWwAAAAd/nana-poor.gif", true, "Pose memelas yang menggemaskan."),
            new FunnyPoseCard.FunnyPoseItem("Kucing Mengangguk", "https://media1.tenor.com/m/Kc6-qPn1jgsAAAAd/cat-yes.gif", true, "Setuju banget!"),
            new FunnyPoseCard.FunnyPoseItem("Tabi Menari", "https://media1.tenor.com/m/nEBfW5_CT8sAAAAd/kitten-tabi.gif", true, "Tari-tarian pagi hari."),
            new FunnyPoseCard.FunnyPoseItem("Kucing Guling", "https://media1.tenor.com/m/cSk38YePjJsAAAAC/cat-meme.gif", true, "Guling kanan kiri auto ngakak.")
        );

        for (FunnyPoseCard.FunnyPoseItem pose : poses) {
            gridPanel.add(new FunnyPoseCard(pose));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }
}
