package swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

public MainFrame() {
// Optional: Remove window frame for bonus
// setUndecorated(true);

setTitle("MeowCare: Gallery of Cat Characters and Breeds");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1200, 800);
setLocationRelativeTo(null);
setLayout(new BorderLayout());

// Add top navbar
add(new Navbar(), BorderLayout.NORTH);

// Add sidebar (fixed left menu)
add(new Sidebar(), BorderLayout.WEST);

// Add scrollable character panel to center
add(new CharacterScrollPanel(), BorderLayout.CENTER);

setVisible(true);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(MainFrame::new);
}
}