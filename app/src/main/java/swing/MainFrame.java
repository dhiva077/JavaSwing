package swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

public MainFrame() {


setTitle("MeowCare: Gallery of Cat Characters and Breeds");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1200, 800);
setLocationRelativeTo(null);
setLayout(new BorderLayout());


add(new Navbar(), BorderLayout.NORTH);


add(new Sidebar(), BorderLayout.WEST);


add(new CharacterScrollPanel(), BorderLayout.CENTER);

setVisible(true);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(MainFrame::new);
}
}