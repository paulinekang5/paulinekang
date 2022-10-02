//Name: Pauline Kang
//Date: 10/18/2021
// Project Name: Checkerboard

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class Checkerboard extends JFrame implements ActionListener{

    JButton btnCreate = new JButton("Create Board");

    JTextField txtHeight = new JTextField(5);
    JTextField txtWidth = new JTextField(5);

    int height = 0;
    int width = 0;

    int xCoord = 100;
    int yCoord = 100;

    public Checkerboard(){
        super("Checkerboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Height: "));
        add(txtHeight);
        add(new JLabel("Width: "));
        add(txtWidth);
        add(btnCreate);

        btnCreate.addActionListener(this);
    }

    public static void main(String[]args){

        //Place components on the applet panel
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        Checkerboard frame = new Checkerboard();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        height = Integer.parseInt(txtHeight.getText());
        width = Integer.parseInt(txtWidth.getText());
        //declare variable to hold which button is called
        Object objSource = event.getSource();

        if(objSource == btnCreate){
            repaint();
        }
    }

    //create the paint method to show graphics
    public void paint(Graphics p){
        super.paint(p);
        xCoord = 100;
        yCoord = 100;
        for(int a = 0; a < height; a++){
            xCoord = 100;
            if(a%2==0){
                for(int b = 0; b < width; b++){
                    if(b%2 == 0){
                        p.setColor(Color.pink);
                        p.fillRect(xCoord, yCoord,35, 35);
                    }
                    else{
                        p.setColor(Color.orange);
                        p.fillRect(xCoord, yCoord,35, 35);
                    }
                    xCoord += 35;
                }
                yCoord += 35;
            }
            else{
                for(int b = 0; b < width; b++){
                    if(b%2 == 0){
                        p.setColor(Color.orange);
                        p.fillRect(xCoord, yCoord,35, 35);
                    }
                    else{
                        p.setColor(Color.pink);
                        p.fillRect(xCoord, yCoord,35, 35);
                    }
                    xCoord += 35;
                }
                yCoord += 35;
            }

        }
        p.setColor(Color.pink);


    }
}
