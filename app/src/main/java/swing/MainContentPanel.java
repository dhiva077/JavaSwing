package swing;

import javax.swing.*;
import java.awt.*;

public class MainContentPanel extends JPanel {
    CardLayout cardLayout;

    public MainContentPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Tambahkan panel-panel konten
        add(new CharacterScrollPanel(), "MeowBase 🩵");
        add(new FunfactPanel(), "Funfact 😻");
        add(new CelebrityPanel(), "Cat Celebrities 👑");
        add(new CatWellnessPanel(), "CatWellness 🥣");
        add(new FunnyPosePanel(), "Funny Poses 😹");
        add(new CatMythsPanel(), "Cat Myths 🔮");
        add(new MeowSignalsPanel(), "MeowSignals 🐾");
        add(new CatSnapsPanel(), "CatSnaps 🎞️");
    }

    public void showCard(String name) {
        cardLayout.show(this, name);
    }
}
