package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {
        super(text);
        setAlignmentX(Component.CENTER_ALIGNMENT); // Agar tetap di tengah secara vertikal dalam layout Y_AXIS
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Lebar maksimal
        setMinimumSize(new Dimension(30, 40)); // Lebar minimal
        setPreferredSize(new Dimension(180, 40)); // Lebar preferred (akan dipengaruhi oleh layout)
        setBackground(Color.decode("#DBD4CE")); // Warna latar belakang tombol
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER); // Teks di tengah horizontal

        addMouseListener(new MouseAdapter() {
            private Color originalBackground = getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                originalBackground = getBackground();
                setBackground(Color.decode("#DDD3D2")); // Efek hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground);
            }
        });
    }
}