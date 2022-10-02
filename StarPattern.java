// NAME: Pauline Kang
// DATE: 10/12/2021
// PROJECT: Star Pattern

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class StarPattern extends JFrame implements ActionListener {
    JTextArea txaOutput = new JTextArea("", 15, 30);
    JButton btnStars = new JButton("STARS");

    String pattern1 = "";
    String pattern2 ="";
    String pattern3 = "";

    public static void main(String[] args){
        StarPattern frame = new StarPattern();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public StarPattern(){
        super("Star Pattern");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(btnStars);
        add(txaOutput);

        btnStars.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();

        // PATTERN 1
        for (int a = 1; a <= 10; a++){
            for(int b = 0; b < a; b++){
                pattern1 += "*";
            }
            pattern1 += "\n";
        }

        // PATTERN 2
        for (int a = 10; a >= 1; a--){
            for(int b = a; b > 0; b--){
                pattern2 += "*";
            }
            pattern2 += "\n";
        }

        // PATTERN 3
        for (int a = 1; a <= 10; a++){
            for(int b = a; b > 0; b--){
                pattern3 += " ";
            }
            for(int c = a; c <= 10; c++){
                pattern3 += "*";
            }

            pattern3 += "\n";
        }

        txaOutput.setText(pattern1 + "\n" + "\n" + pattern2 + "\n" + "\n" + pattern3);
    }
}
