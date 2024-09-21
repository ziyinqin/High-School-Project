import javax.swing.*;
import java.awt.*;

class BackgroundImage extends JFrame
{
    public BackgroundImage()
    {
        setTitle("");
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("Pokemon.png")));
        setLayout(new FlowLayout());
        setSize(500,500);
    }
} 