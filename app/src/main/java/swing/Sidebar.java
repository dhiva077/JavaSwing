package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Sidebar extends JPanel {
    public Sidebar(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#BBAEA5"));
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        add(Box.createVerticalStrut(8));

        String[] buttonLabels = {
            "MeowBase 🩵", "Funfact 😻", "Cat Celebrities 👑", "CatWellness 🥣",
            "Funny Poses 😹", "Cat Myths 🔮", "MeowSignals 🐾", "CatSnaps 🎞️"
        };

        for (String label : buttonLabels) {
            SidebarButton button = new SidebarButton(label);
            button.setActionCommand(label);
            button.addActionListener(listener);
            add(button);
            add(Box.createVerticalStrut(8));
        }

        add(Box.createVerticalGlue());
    }
}
