package swing;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {

    public Sidebar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#BBAEA5"));
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        add(Box.createVerticalStrut(8));

        String[] buttonLabels = {
                "Home", "Characters", "Tier List", "Memory of Chaos",
                "Light Cones", "Relics", "Guides", "Tools"
        };

        for (String label : buttonLabels) {
            add(new SidebarButton(label));
            add(Box.createVerticalStrut(8)); // Jarak vertikal
        }

        add(Box.createVerticalGlue());
    }
}