package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {
        super(text);
        setAlignmentX(Component.CENTER_ALIGNMENT); 
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); 
        setMinimumSize(new Dimension(30, 40)); 
        setPreferredSize(new Dimension(180, 40)); 
        setBackground(Color.decode("#DBD4CE")); 
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER); 

        addMouseListener(new MouseAdapter() {
            private Color originalBackground = getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                originalBackground = getBackground();
                setBackground(Color.decode("#DDD3D2"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground);
            }
        });
    }
}