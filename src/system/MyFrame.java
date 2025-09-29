package system;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\Student Record Logo.png");
        this.setIconImage(icon.getImage());

        this.setTitle("Student Record System");
        this.setSize(1920, 1080);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xF5FFFA));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
