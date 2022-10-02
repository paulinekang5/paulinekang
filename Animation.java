//Name: Pauline Kang
//Date: 10/18/2021
/*
 * This project codes a timer
 * and animation
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;


public class Animation extends JFrame implements ActionListener{
    //timer buttons
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");

    //Location variables for circle
    int intX = 50;
    int intY = 400;
    int intXAmount = 10;

    boolean onOff = false;
    Timer myTimer = new Timer(100, this);

    //create the init method
    //the init is the first method to run

    public Animation(){
        super("Button Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //pnlInput.setLayout(new GridLayout(0,2));

        //timer buttons
        add(btnStart);
        add(btnStop);

        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
    }

    public static void main(String[]args){

        //Place components on the applet panel
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        Animation frame = new Animation();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }

    //when you push the button it comes this method
    public void actionPerformed(ActionEvent event){
        //declare variable to hold which button is called
        Object objSource = event.getSource();
        //requestFocus();

        if(objSource == btnStart){
            startTheTimer();
        }
        else if(objSource == btnStop){
            stopTheTimer();
        }
        if(onOff){
            if (intX > getWidth()){
                intXAmount *= -1;
            }
            else if(intX < 0){
                intX *= -1;
            }
            intX += intXAmount;
            repaint();
        }
    }

    //create the paint method to show graphics
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(intX, intY,50, 50);
    }
    public void Update(Graphics gr){
        //call the paint method
        paint(gr);
    }

    public void startTheTimer(){
        myTimer.start();
        onOff = true;
    }

    public void stopTheTimer(){
        myTimer.stop();
        onOff = false;
    }
}


